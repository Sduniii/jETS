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
    private final boolean isLink;
    private List<ProjectTreeNode> children;

    public ProjectTreeNode(String name, Object userObject) {
        this(name, userObject, false);
    }

    public ProjectTreeNode(String name, Object userObject, boolean isLink) {
        this.name = name;
        this.userObject = userObject;
        this.isLink = isLink;
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

        Object target = userObject;
        if (userObject instanceof DeviceInstanceRef) {
            DeviceInstanceRef ref = (DeviceInstanceRef) userObject;
            target = Jets.currentContext.findById(ref.getRefId());
            if (target == null) {
                logger.warn("Could not resolve DeviceInstanceRef: {}", ref.getRefId());
                target = userObject;
            }
        }

        if (target instanceof DeviceInstance) {
            DeviceInstance di = (DeviceInstance) target;
            
            if (di.getParameterInstanceRefs() != null && di.getParameterInstanceRefs().getParameterInstanceRef() != null) {
                ProjectTreeNode paramFolder = new ProjectTreeNode("🔧 Parameters", null);
                for (ParameterInstanceRef p : di.getParameterInstanceRefs().getParameterInstanceRef()) {
                    paramFolder.getChildren().add(new ProjectTreeNode(getParameterLabel(di, p) + ": " + p.getValue(), p));
                }
                if (!paramFolder.getChildren().isEmpty()) children.add(paramFolder);
            }

            if (di.getComObjectInstanceRefs() != null && di.getComObjectInstanceRefs().getComObjectInstanceRef() != null) {
                ProjectTreeNode koFolder = new ProjectTreeNode("📡 Communication Objects", null);
                for (ComObjectInstanceRef cor : di.getComObjectInstanceRefs().getComObjectInstanceRef()) {
                    koFolder.getChildren().add(new ProjectTreeNode(getKoLabel(di, cor), cor));
                }
                if (!koFolder.getChildren().isEmpty()) children.add(koFolder);
            }
            
            addOtherChildren(target, List.of("getParameterInstanceRefs", "getComObjectInstanceRefs"));
            return;
        }

        if (!isLink && target instanceof ComObjectInstanceRef) {
            ComObjectInstanceRef cor = (ComObjectInstanceRef) target;
            List<String> gaIds = Jets.currentContext.getLinkedGroupAddressIds(cor);
            for (String gaId : gaIds) {
                GroupAddress ga = Jets.currentContext.findGroupAddress(gaId);
                if (ga != null) {
                    children.add(new ProjectTreeNode("🔗 Linked GA: " + ga.getName() + " [" + formatGroupAddress(ga.getAddress()) + "]", ga, true));
                }
            }
            return;
        }

        if (!isLink && target instanceof GroupAddress) {
            GroupAddress ga = (GroupAddress) target;
            String gaIdShort = ga.getId();
            if (gaIdShort.contains("_")) gaIdShort = gaIdShort.substring(gaIdShort.lastIndexOf('_') + 1);
            
            List<DeviceInstance> allDevs = Jets.currentContext.findAllDevices();
            for (DeviceInstance di : allDevs) {
                if (di.getComObjectInstanceRefs() != null) {
                    for (ComObjectInstanceRef cor : di.getComObjectInstanceRefs().getComObjectInstanceRef()) {
                        List<String> linkedIds = Jets.currentContext.getLinkedGroupAddressIds(cor);
                        boolean linked = false;
                        for (String lid : linkedIds) {
                            if (lid.equals(ga.getId()) || lid.equals(gaIdShort)) {
                                linked = true;
                                break;
                            }
                        }
                        if (linked) {
                            String label = "🔗 Linked KO: " + getDeviceDisplayName(di) + " -> " + getKoLabel(di, cor);
                            children.add(new ProjectTreeNode(label, cor, true));
                        }
                    }
                }
            }
            addOtherChildren(target, List.of());
            return;
        }

        if (target instanceof ParameterInstanceRef || target instanceof ComObject || target instanceof ApplicationProgramStatic_Parameters_Parameter) {
            return;
        }

        addOtherChildren(target, List.of());
    }

    private void addOtherChildren(Object target, List<String> skipMethods) {
        if (!(target instanceof KnxBase)) return;
        Method[] methods = target.getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get") && method.getParameterCount() == 0 && 
                !method.getName().equals("getClass") && !method.getName().equals("getProject") &&
                !skipMethods.contains(method.getName())) {
                try {
                    Object result = method.invoke(target);
                    if (result instanceof KnxBase) {
                        String nodeName = method.getName().substring(3);
                        children.add(new ProjectTreeNode(getDisplayName((KnxBase)result, nodeName), result));
                    } else if (result instanceof Collection) {
                        for (Object item : (Collection<?>) result) {
                            if (item instanceof KnxBase) {
                                String nodeName = method.getName().substring(3);
                                children.add(new ProjectTreeNode(getDisplayName((KnxBase)item, nodeName), item));
                            }
                        }
                    }
                } catch (Exception e) { logger.error("Error building children", e); }
            }
        }
    }

    private String getParameterLabel(DeviceInstance di, ParameterInstanceRef p) {
        String text = Jets.currentContext.findParameterText(di, p.getRefId());
        return (text != null && !text.isEmpty()) ? text : p.getRefId();
    }

    private String getKoLabel(DeviceInstance di, ComObjectInstanceRef cor) {
        ComObject co = Jets.currentContext.findComObject(di, cor.getRefId());
        String num = (co != null) ? String.valueOf(co.getNumber()) : "?";
        String name = (cor.getText() != null && !cor.getText().isEmpty()) ? cor.getText() : (co != null ? co.getText() : "");
        String func = (cor.getFunctionText() != null && !cor.getFunctionText().isEmpty()) ? cor.getFunctionText() : (co != null ? co.getFunctionText() : "");
        
        StringBuilder sb = new StringBuilder("KO " + num + ": ");
        if (!func.isEmpty()) sb.append(func);
        if (!name.isEmpty()) {
            if (!func.isEmpty()) sb.append(" - ");
            sb.append(name);
        }
        if (func.isEmpty() && name.isEmpty()) sb.append(cor.getRefId());
        return sb.toString();
    }

    private String getDisplayName(KnxBase item, String fallbackName) {
        Object displayItem = item;
        if (item instanceof DeviceInstanceRef) {
            DeviceInstanceRef ref = (DeviceInstanceRef) item;
            displayItem = Jets.currentContext.findById(ref.getRefId());
        }
        if (displayItem instanceof DeviceInstance) {
            DeviceInstance di = (DeviceInstance) displayItem;
            String prodName = Jets.currentContext.resolveProductName(di);
            String name = (di.getName() != null && !di.getName().isEmpty()) ? di.getName() : prodName;
            return "Device: " + (name != null ? name : "Unknown") + " [." + di.getAddress() + "]";
        }
        try {
            Method m = displayItem.getClass().getMethod("getName");
            String name = (String) m.invoke(displayItem);
            if (name != null && !name.isEmpty()) return name;
        } catch (Exception ignored) {}
        return fallbackName;
    }

    private String getDeviceDisplayName(DeviceInstance di) {
        String prodName = Jets.currentContext.resolveProductName(di);
        String name = (di.getName() != null && !di.getName().isEmpty()) ? di.getName() : prodName;
        return (name != null ? name : "Unknown") + " [." + di.getAddress() + "]";
    }

    private String formatGroupAddress(long address) {
        long p = (address >> 11) & 0x1F;
        long m = (address >> 8) & 0x07;
        long s = address & 0xFF;
        return p + "/" + m + "/" + s;
    }

    private String formatIndividualAddress(int address) {
        int a = (address >> 12) & 0x0F;
        int l = (address >> 8) & 0x0F;
        int d = address & 0xFF;
        return a + "." + l + "." + d;
    }

    @Override
    public String toString() { return name; }
}
