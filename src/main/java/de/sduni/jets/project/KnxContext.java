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
        return idMap.get(id);
    }

    /**
     * Stricly resolves a parameter definition following the relation:
     * ParameterRef (Id) -> Parameter (RefId)
     */
    public ApplicationProgramStatic_Parameters_Parameter resolveParameterDefinition(ApplicationProgram ap, String id) {
        if (id == null || ap == null) return null;

        Object found = idMap.get(id);
        
        // 1. If it's directly a Parameter, we are done
        if (found instanceof ApplicationProgramStatic_Parameters_Parameter) {
            return (ApplicationProgramStatic_Parameters_Parameter) found;
        }

        // 2. If it's a ParameterRef, follow its RefId
        if (found instanceof ParameterRef) {
            return resolveParameterDefinition(ap, ((ParameterRef) found).getRefId());
        }

        // 3. Fallback: Search manually in lists if not indexed
        if (ap.getStatic() != null) {
            if (ap.getStatic().getParameterRefs() != null) {
                for (ParameterRef ref : ap.getStatic().getParameterRefs().getParameterRef()) {
                    if (id.equals(ref.getId())) return resolveParameterDefinition(ap, ref.getRefId());
                }
            }
            if (ap.getStatic().getParameters() != null) {
                return searchParameterInList(ap.getStatic().getParameters(), id);
            }
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
                                if (m.getLanguages() != null) {
                                    String translated = findTranslationInLanguageData(m.getLanguages().getLanguage(), refId, "Text");
                                    if (translated != null) return translated;
                                }
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
        
        // COR IDs in 0.xml are usually the same as CO IDs in the Application XML
        // Search in the specific program
        ApplicationProgram ap = findApplicationProgram(di.getHardware2ProgramRefId());
        if (ap != null && ap.getStatic() != null && ap.getStatic().getComObjectTable() != null) {
            for (ComObject co : ap.getStatic().getComObjectTable().getComObject()) {
                if (corRefId.equals(co.getId()) || co.getId().endsWith("_" + corRefId)) {
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
        ApplicationProgram ap = findApplicationProgram(di.getHardware2ProgramRefId());
        if (ap == null) return null;

        // 1. Try Translation for the specific ID (could be a RefId)
        String translated = findTranslation(ap.getLanguage(), paramRefId, "Text");
        if (translated != null) return translated;

        // 2. Resolve definition to get base parameter
        ApplicationProgramStatic_Parameters_Parameter pDef = resolveParameterDefinition(ap, paramRefId);
        if (pDef != null) {
            String baseTranslated = findTranslation(ap.getLanguage(), pDef.getId(), "Text");
            if (baseTranslated != null) return baseTranslated;
            return pDef.getText();
        }
        
        return null;
    }

    public String resolveParameterValueText(DeviceInstance di, String paramRefId, String rawValue) {
        if (di == null || paramRefId == null || rawValue == null) return rawValue;

        ApplicationProgram ap = findApplicationProgram(di.getHardware2ProgramRefId());
        if (ap == null) return rawValue;

        ApplicationProgramStatic_Parameters_Parameter pDef = resolveParameterDefinition(ap, paramRefId);
        if (pDef == null) return rawValue;

        String typeRef = pDef.getParameterType();
        ParameterType pt = null;
        if (ap.getStatic() != null && ap.getStatic().getParameterTypes() != null) {
            for (ParameterType t : ap.getStatic().getParameterTypes().getParameterType()) {
                if (typeRef.equals(t.getId())) { pt = t; break; }
            }
        }

        if (pt == null) return rawValue;

        if (pt.getTypeRestriction() != null && !pt.getTypeRestriction().getEnumeration().isEmpty()) {
            try {
                long val = Long.parseLong(rawValue);
                for (ParameterType_TypeRestriction_Enumeration en : pt.getTypeRestriction().getEnumeration()) {
                    if (en.getValue() == val) {
                        String translated = findTranslation(ap.getLanguage(), en.getId(), "Text");
                        if (translated != null) return translated;
                        return en.getText();
                    }
                }
            } catch (NumberFormatException ignored) {}
        }

        return rawValue;
    }

    private String findTranslation(List<Language> languages, String refId, String attribute) {
        if (languages == null) return null;
        for (Language l : languages) {
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
                if (entry.getKey().endsWith("_" + refId)) {
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

    private ApplicationProgramStatic_Parameters_Parameter searchParameterInList(ApplicationProgramStatic_Parameters list, String id) {
        if (list.getParameter() != null) {
            for (ApplicationProgramStatic_Parameters_Parameter p : list.getParameter()) {
                if (id.equals(p.getId())) return p;
            }
        }
        if (list.getUnion() != null) {
            for (ApplicationProgramStatic_Parameters_Union u : list.getUnion()) {
                if (u.getParameter() != null) {
                    for (UnionParameter up : u.getParameter()) {
                        if (id.equals(up.getId())) {
                            ApplicationProgramStatic_Parameters_Parameter p = new ApplicationProgramStatic_Parameters_Parameter();
                            p.setId(up.getId()); p.setName(up.getName()); p.setText(up.getText());
                            p.setParameterType(up.getParameterType());
                            return p;
                        }
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
            // Index with exact ID
            if (!idMap.containsKey(id)) idMap.put(id, obj);
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
