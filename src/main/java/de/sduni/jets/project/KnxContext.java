package de.sduni.jets.project;

import de.sduni.jets.model.v20.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnxContext {
    private static final Logger logger = LoggerFactory.getLogger(KnxContext.class);
    public final KNX root;
    private final Map<String, Object> idMap = new HashMap<>();
    private final Map<String, GroupAddress> gaMap = new HashMap<>();
    private final Map<String, String> deviceNameMap = new HashMap<>();

    public KnxContext(KNX root) {
        this.root = root;
        index();
    }

    private void index() {
        logger.info("Indexing project objects...");
        idMap.clear();
        gaMap.clear();
        deviceNameMap.clear();
        deepIndex(root);
        logger.info("Indexed {} objects by ID.", idMap.size());
    }

    public Object findById(String id) {
        if (id == null) return null;
        Object found = idMap.get(id);
        if (found != null) return found;
        
        if (id.contains("_R-")) {
            String baseId = id.substring(0, id.lastIndexOf("_R-"));
            found = idMap.get(baseId);
            if (found != null) return found;
        }
        return null;
    }

    public String getDptForGroupAddress(String addrStr) {
        GroupAddress ga = gaMap.get(addrStr);
        return (ga != null) ? ga.getDatapointType() : null;
    }

    public String getGroupName(String addrStr) {
        GroupAddress ga = gaMap.get(addrStr);
        return (ga != null) ? ga.getName() : "";
    }

    public String getDeviceName(String addrStr) {
        return deviceNameMap.getOrDefault(addrStr, "");
    }

    /**
     * PATH A: Resolve full product name for a device.
     */
    public String resolveProductName(DeviceInstance di) {
        if (di == null || di.getProductRefId() == null || root.getManufacturerData() == null) return null;
        String refId = di.getProductRefId();
        
        for (ManufacturerData_Manufacturer m : root.getManufacturerData().getManufacturer()) {
            if (m.getHardware() != null) {
                for (Hardware h : m.getHardware().getHardware()) {
                    if (h.getProducts() != null) {
                        for (Hardware_Products_Product p : h.getProducts().getProduct()) {
                            if (refId.equals(p.getId())) {
                                // 1. Try Translation (LanguageData / TranslationUnit structure)
                                if (m.getLanguages() != null) {
                                    String translated = findTranslationInLanguageData(m.getLanguages().getLanguage(), refId, "Text");
                                    if (translated != null) return translated;
                                }
                                // 2. Fallback to attribute
                                return p.getText();
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private String findTranslationInLanguageData(List<LanguageData> languages, String refId, String attribute) {
        if (languages == null) return null;
        for (LanguageData l : languages) {
            for (LanguageData_TranslationUnit tu : l.getTranslationUnit()) {
                if (tu.getTranslationElement() != null) {
                    for (LanguageData_TranslationUnit_TranslationElement te : tu.getTranslationElement()) {
                        if (refId.equals(te.getRefId())) {
                            for (LanguageData_TranslationUnit_TranslationElement_Translation trans : te.getTranslation()) {
                                if (attribute.equals(trans.getAttributeName())) return trans.getValue();
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public List<DeviceInstance> findAllDevices() {
        List<DeviceInstance> list = new ArrayList<>();
        for (Object obj : idMap.values()) {
            if (obj instanceof DeviceInstance) {
                DeviceInstance di = (DeviceInstance) obj;
                if (list.stream().noneMatch(existing -> di.getId() != null && di.getId().equals(existing.getId()))) {
                    list.add(di);
                }
            }
        }
        return list;
    }

    /**
     * PATH B: Resolve communication object definition for a specific device instance.
     */
    public ComObject findComObject(DeviceInstance di, String corRefId) {
        if (corRefId == null || di == null) return null;
        
        String localId = corRefId;
        if (corRefId.contains("_R-")) {
            localId = corRefId.substring(0, corRefId.lastIndexOf("_R-"));
        }
        
        ApplicationProgram ap = findApplicationProgram(di.getHardware2ProgramRefId());
        if (ap != null && ap.getStatic() != null && ap.getStatic().getComObjectTable() != null) {
            for (ComObject co : ap.getStatic().getComObjectTable().getComObject()) {
                if (co.getId().endsWith("_" + localId) || co.getId().equals(localId)) {
                    // Enrich CO with translated texts if available
                    TranslationElement te = findTranslationElement(ap.getLanguage(), co.getId());
                    if (te != null) {
                        if (te.getFunctionText() != null) co.setFunctionText(te.getFunctionText());
                        if (te.getText() != null) co.setText(te.getText());
                    }
                    return co;
                }
            }
        }
        return null;
    }

    public ApplicationProgram findApplicationProgram(String h2pRefId) {
        if (h2pRefId == null || root.getManufacturerData() == null) return null;
        
        String apId = null;
        for (ManufacturerData_Manufacturer m : root.getManufacturerData().getManufacturer()) {
            if (m.getHardware() != null) {
                for (Hardware h : m.getHardware().getHardware()) {
                    if (h.getHardware2Programs() != null) {
                        for (Hardware2Program h2p : h.getHardware2Programs().getHardware2Program()) {
                            if (h2pRefId.equals(h2p.getId()) || h2p.getId().endsWith("_" + h2pRefId)) {
                                if (!h2p.getApplicationProgramRef().isEmpty()) {
                                    apId = h2p.getApplicationProgramRef().get(0).getRefId();
                                    break;
                                }
                            }
                        }
                    }
                    if (apId != null) break;
                }
            }
            if (apId != null) break;
        }

        if (apId == null) apId = h2pRefId;

        for (ManufacturerData_Manufacturer m : root.getManufacturerData().getManufacturer()) {
            if (m.getApplicationPrograms() != null) {
                for (ApplicationProgram ap : m.getApplicationPrograms().getApplicationProgram()) {
                    if (apId.equals(ap.getId()) || ap.getId().endsWith("_" + apId)) {
                        return ap;
                    }
                }
            }
        }
        return null;
    }

    public String findParameterText(DeviceInstance di, String paramRefId) {
        if (paramRefId == null || di == null) return null;
        
        String baseId = paramRefId;
        if (paramRefId.contains("_R-")) {
            baseId = paramRefId.substring(0, paramRefId.lastIndexOf("_R-"));
        }

        ApplicationProgram ap = findApplicationProgram(di.getHardware2ProgramRefId());
        if (ap != null && ap.getStatic() != null && ap.getStatic().getParameters() != null) {
            // 1. Try Translation first
            String translated = findTranslation(ap.getLanguage(), baseId, "Text");
            if (translated != null) return translated;
            
            // 2. Search in parameter list
            return searchParameterInList(ap.getStatic().getParameters(), baseId);
        }
        return null;
    }

    private String findTranslation(List<Language> languages, String refId, String attribute) {
        if (languages == null) return null;
        for (Language l : languages) {
            // Prefer en-US or de-DE or just anything
            for (TranslationElement te : l.getTranslationElement()) {
                if (refId.equals(te.getRefId())) {
                    if ("Text".equals(attribute)) return te.getText();
                    if ("FunctionText".equals(attribute)) return te.getFunctionText();
                }
            }
        }
        return null;
    }

    private TranslationElement findTranslationElement(List<Language> languages, String refId) {
        if (languages == null) return null;
        for (Language l : languages) {
            for (TranslationElement te : l.getTranslationElement()) {
                if (refId.equals(te.getRefId())) return te;
            }
        }
        return null;
    }

    public GroupAddress findGroupAddress(String refId) {
        if (refId == null) return null;
        Object obj = findById(refId);
        if (obj instanceof GroupAddress) return (GroupAddress) obj;
        for (Map.Entry<String, Object> entry : idMap.entrySet()) {
            if (entry.getValue() instanceof GroupAddress) {
                if (entry.getKey().endsWith("_" + refId) || entry.getKey().equals(refId)) {
                    return (GroupAddress) entry.getValue();
                }
            }
        }
        return null;
    }

    public List<String> getLinkedGroupAddressIds(ComObjectInstanceRef cor) {
        List<String> ids = new ArrayList<>();
        if (cor.getLinks() != null && !cor.getLinks().isEmpty()) {
            String[] split = cor.getLinks().split(" ");
            for (String s : split) if (!s.trim().isEmpty()) ids.add(s.trim());
        }
        if (cor.getConnect() != null) {
            for (ComObjectInstanceRef_Connect c : cor.getConnect()) {
                if (c.getGroupAddressRefId() != null) ids.add(c.getGroupAddressRefId());
            }
        }
        return ids;
    }

    private String searchParameterInList(ApplicationProgramStatic_Parameters list, String id) {
        if (list.getParameter() != null) {
            for (ApplicationProgramStatic_Parameters_Parameter p : list.getParameter()) {
                if (id.equals(p.getId())) return p.getText();
            }
        }
        if (list.getUnion() != null) {
            for (ApplicationProgramStatic_Parameters_Union u : list.getUnion()) {
                if (u.getParameter() != null) {
                    for (UnionParameter p : u.getParameter()) {
                        if (id.equals(p.getId())) return p.getText();
                    }
                }
            }
        }
        return null;
    }

    private void deepIndex(Object obj) {
        if (obj == null) return;
        String id = getObjectId(obj);
        if (id != null && !id.isEmpty()) {
            if (idMap.containsKey(id) && idMap.get(id) == obj) return;
            idMap.put(id, obj);
            if (id.contains("_")) {
                String shortId = id.substring(id.lastIndexOf('_') + 1);
                if (!idMap.containsKey(shortId)) idMap.put(shortId, obj);
            }
        }
        if (obj instanceof GroupAddress) {
            GroupAddress ga = (GroupAddress) obj;
            gaMap.put(formatGroupAddress(ga.getAddress()), ga);
        } else if (obj instanceof DeviceInstance) {
            DeviceInstance dev = (DeviceInstance) obj;
            deviceNameMap.put(formatIndividualAddress(dev.getAddress()), dev.getName());
        }
        if (obj instanceof Collection) {
            for (Object item : (Collection<?>) obj) deepIndex(item);
        } else if (obj instanceof KnxBase) {
            for (Method m : obj.getClass().getMethods()) {
                if (m.getName().startsWith("get") && m.getParameterCount() == 0 && !m.getName().equals("getClass")) {
                    try {
                        Object val = m.invoke(obj);
                        if (val != null && (val instanceof KnxBase || val instanceof Collection)) deepIndex(val);
                    } catch (Exception ignored) {}
                }
            }
        }
    }

    private String getObjectId(Object obj) {
        try {
            Method m = obj.getClass().getMethod("getId");
            return (String) m.invoke(obj);
        } catch (Exception e) { return null; }
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
}
