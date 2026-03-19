package de.sduni.jets.ui;

import de.sduni.jets.model.v20.*;
import de.sduni.jets.Jets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProjectTreeNode {
    private static final Logger logger = LoggerFactory.getLogger(ProjectTreeNode.class);
    private final Object userObject;
    private final String name;
    private List<ProjectTreeNode> children;

    public ProjectTreeNode(String name, Object userObject) {
        this.name = name;
        this.userObject = userObject;
    }

    public Object getUserObject() {
        return userObject;
    }

    public String getName() {
        return name;
    }

    public void reload() {
        children = null;
    }

    public List<ProjectTreeNode> getChildren() {
        if (children == null) {
            children = new ArrayList<>();
            buildChildren();
        }
        return children;
    }

    private void buildChildren() {
        if (userObject == null) return;

        // 1. Resolve Target
        Object target = userObject;
        if (userObject instanceof DeviceInstanceRef) {
            DeviceInstanceRef ref = (DeviceInstanceRef) userObject;
            target = Jets.currentContext.findById(ref.getRefId());
            if (target == null) {
                logger.warn("Could not resolve DeviceInstanceRef: {}", ref.getRefId());
                target = userObject; // Stay at ref if not found
            }
        }

        // 2. Specialized structure for DeviceInstance
        if (target instanceof DeviceInstance) {
            DeviceInstance di = (DeviceInstance) target;
            
            // Parameters
            if (di.getParameterInstanceRefs() != null && di.getParameterInstanceRefs().getParameterInstanceRef() != null) {
                ProjectTreeNode paramFolder = new ProjectTreeNode("🔧 Parameters", null);
                for (ParameterInstanceRef p : di.getParameterInstanceRefs().getParameterInstanceRef()) {
                    String label = getParameterLabel(p);
                    paramFolder.getChildren().add(new ProjectTreeNode(label + ": " + p.getValue(), p));
                }
                if (!paramFolder.getChildren().isEmpty()) children.add(paramFolder);
            }

            // ComObjects
            if (di.getComObjectInstanceRefs() != null && di.getComObjectInstanceRefs().getComObjectInstanceRef() != null) {
                ProjectTreeNode koFolder = new ProjectTreeNode("📡 Communication Objects", null);
                for (ComObjectInstanceRef cor : di.getComObjectInstanceRefs().getComObjectInstanceRef()) {
                    String label = getKoLabel(cor);
                    koFolder.getChildren().add(new ProjectTreeNode(label, cor));
                }
                if (!koFolder.getChildren().isEmpty()) children.add(koFolder);
            }
            
            addOtherChildren(target, List.of("getParameterInstanceRefs", "getComObjectInstanceRefs"));
            return;
        }

        // 3. Normal recursion
        addOtherChildren(target, List.of());
    }

    private void addOtherChildren(Object target, List<String> skipMethods) {
        if (!(target instanceof KnxBase)) return;
        
        Method[] methods = target.getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get") && method.getParameterCount() == 0 && !method.getName().equals("getClass")) {
                if (skipMethods.contains(method.getName())) continue;
                
                try {
                    Object value = method.invoke(target);
                    if (value == null) continue;

                    String propName = method.getName().substring(3);

                    if (value instanceof KnxBase) {
                        String display = getDisplayName((KnxBase) value, propName);
                        children.add(new ProjectTreeNode(display, value));
                    } else if (value instanceof Collection<?>) {
                        for (Object item : (Collection<?>) value) {
                            if (item instanceof KnxBase) {
                                String display = getDisplayName((KnxBase) item, propName);
                                children.add(new ProjectTreeNode(display, item));
                            }
                        }
                    }
                } catch (Exception ignored) {}
            }
        }
    }

    private String getParameterLabel(ParameterInstanceRef p) {
        Object target = Jets.currentContext.findById(p.getRefId());
        if (target instanceof ApplicationProgramStatic_Parameters_Parameter) {
            ApplicationProgramStatic_Parameters_Parameter appParam = (ApplicationProgramStatic_Parameters_Parameter) target;
            if (appParam.getText() != null && !appParam.getText().isEmpty()) return appParam.getText();
            if (appParam.getName() != null && !appParam.getName().isEmpty()) return appParam.getName();
        }
        return p.getRefId();
    }

    private String getKoLabel(ComObjectInstanceRef cor) {
        String koNum = "";
        Object coTarget = Jets.currentContext.findById(cor.getRefId());
        if (coTarget instanceof ComObject) {
            koNum = ((ComObject) coTarget).getNumber() + ": ";
        }
        return "KO " + koNum + (cor.getFunctionText() != null ? cor.getFunctionText() : "") + 
               (cor.getText() != null ? " - " + cor.getText() : "");
    }

    private String getDisplayName(KnxBase item, String fallbackName) {
        Object displayItem = item;
        if (item instanceof DeviceInstanceRef) {
            Object resolved = Jets.currentContext.findById(((DeviceInstanceRef) item).getRefId());
            if (resolved != null) displayItem = resolved;
        }

        String typeName = displayItem.getClass().getSimpleName();
        String addr = "";
        try {
            Method getAddr = displayItem.getClass().getMethod("getAddress");
            Object addrVal = getAddr.invoke(displayItem);
            if (addrVal != null) {
                if (displayItem instanceof DeviceInstance) addr = " [." + addrVal + "]";
                else addr = " [" + addrVal + "]";
            }
        } catch (Exception ignored) {}

        String label = "";
        try {
            Method getName = displayItem.getClass().getMethod("getName");
            Object nameVal = getName.invoke(displayItem);
            if (nameVal != null && !nameVal.toString().isEmpty()) label = nameVal.toString();
        } catch (Exception ignored) {}
        
        if (label.isEmpty()) {
            try {
                Method getId = displayItem.getClass().getMethod("getId");
                Object idVal = getId.invoke(displayItem);
                if (idVal != null && !idVal.toString().isEmpty()) label = idVal.toString();
            } catch (Exception ignored) {}
        }

        if (displayItem instanceof Topology_Area) typeName = "Area";
        else if (displayItem instanceof Topology_Area_Line) typeName = "Line";
        else if (displayItem instanceof DeviceInstance) typeName = "Device";
        else if (displayItem instanceof GroupAddress) {
            typeName = "Group";
            addr = " [" + formatGroupAddress(((GroupAddress) displayItem).getAddress()) + "]";
        }

        if (!label.isEmpty()) return typeName + ": " + label + addr;
        return typeName + " (" + fallbackName + ")" + addr;
    }

    private String formatGroupAddress(long address) {
        long p = (address >> 11) & 0x1F;
        long m = (address >> 8) & 0x07;
        long s = address & 0xFF;
        return p + "/" + m + "/" + s;
    }

    @Override
    public String toString() {
        return name;
    }
}
