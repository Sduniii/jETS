package de.sduni.jets.project;

import de.sduni.jets.model.v20.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class KnxContext {
    private static final Logger logger = LoggerFactory.getLogger(KnxContext.class);
    private final KNX root;
    private final Map<String, Object> idMap = new HashMap<>();
    private final Map<String, GroupAddress> gaMap = new HashMap<>();
    private final Map<String, String> deviceNameMap = new HashMap<>();

    public KnxContext(KNX root) {
        this.root = root;
        logger.info("Indexing project objects...");
        deepIndex(root);
        logger.info("Indexed {} objects by ID.", idMap.size());
    }

    private void deepIndex(Object obj) {
        if (obj == null) return;
        
        // 1. Get ID and index
        String id = getObjectId(obj);
        if (id != null && !id.isEmpty()) {
            if (idMap.containsKey(id) && idMap.get(id) == obj) return; // Already indexed
            idMap.put(id, obj);
            // KNX ID normalization (strip prefixes if necessary)
            if (id.contains("_")) {
                String shortId = id.substring(id.lastIndexOf('_') + 1);
                if (!idMap.containsKey(shortId)) idMap.put(shortId, obj);
            }
        }

        // 2. Specialized Indexing
        if (obj instanceof GroupAddress) {
            GroupAddress ga = (GroupAddress) obj;
            gaMap.put(formatGroupAddress(ga.getAddress()), ga);
        } else if (obj instanceof DeviceInstance) {
            DeviceInstance dev = (DeviceInstance) obj;
            deviceNameMap.put(formatIndividualAddress(dev.getAddress()), dev.getName());
            // logger.debug("Reached DeviceInstance: {} (ID: {})", dev.getName(), dev.getId());
        }

        // 3. Deep recursion into all fields/methods
        if (obj instanceof Collection) {
            for (Object item : (Collection<?>) obj) deepIndex(item);
        } else if (obj instanceof KnxBase) {
            // Structural Logging
            if (obj instanceof KNX) logger.debug("Indexing KNX root...");
            else if (obj instanceof Project) {
                Project p = (Project) obj;
                String pName = (p.getProjectInformation() != null) ? p.getProjectInformation().getName() : "Unknown";
                logger.debug("Indexing Project: {} (ID: {})", pName, p.getId());
            } else if (obj instanceof Project_Installations_Installation) logger.debug("Indexing Installation: {}", ((Project_Installations_Installation)obj).getName());
            else if (obj instanceof Topology) logger.debug("Indexing Topology...");
            else if (obj instanceof Topology_Area) {
                Topology_Area area = (Topology_Area) obj;
                int lineCount = (area.getLine() != null) ? area.getLine().size() : 0;
                logger.debug("Indexing Area: {} ({} lines)", area.getName(), lineCount);
            } else if (obj instanceof Topology_Area_Line) {
                Topology_Area_Line line = (Topology_Area_Line) obj;
                int devCount = (line.getDeviceInstance() != null) ? line.getDeviceInstance().size() : 0;
                logger.debug("Indexing Line: {} ({} devices)", line.getName(), devCount);
            } else if (obj instanceof DeviceInstance) logger.debug("Indexing Device: {} (Addr: {})", ((DeviceInstance)obj).getName(), formatIndividualAddress(((DeviceInstance)obj).getAddress()));

            // Recursively scan all "get*" methods that return something interesting
            for (Method m : obj.getClass().getMethods()) {
                if (m.getName().startsWith("get") && m.getParameterCount() == 0 && 
                    !m.getName().equals("getClass")) {
                    try {
                        Object val = m.invoke(obj);
                        if (val != null) {
                            if (val instanceof KnxBase || val instanceof Collection) {
                                deepIndex(val);
                            }
                        }
                    } catch (Exception ignored) {}
                }
            }
        }
    }

    private String getObjectId(Object obj) {
        try {
            Method m = obj.getClass().getMethod("getId");
            return (String) m.invoke(obj);
        } catch (Exception e) {
            try {
                Field f = findField(obj.getClass(), "Id");
                if (f != null) {
                    f.setAccessible(true);
                    return (String) f.get(obj);
                }
            } catch (Exception ignored) {}
        }
        return null;
    }

    private Field findField(Class<?> clazz, String name) {
        while (clazz != null) {
            try { return clazz.getDeclaredField(name); } 
            catch (NoSuchFieldException e) { clazz = clazz.getSuperclass(); }
        }
        return null;
    }

    public Object findById(String id) {
        if (id == null) return null;
        Object found = idMap.get(id);
        if (found != null) return found;
        
        // Relative search
        for (Map.Entry<String, Object> entry : idMap.entrySet()) {
            if (entry.getKey().endsWith("_" + id) || id.endsWith("_" + entry.getKey())) {
                return entry.getValue();
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

    public KNX getRoot() { return root; }

    public ComObject findComObject(String comObjectRefId) {
        if (comObjectRefId == null || root.getManufacturerData() == null) return null;
        // Search in manufacturer data
        for (ManufacturerData_Manufacturer m : root.getManufacturerData().getManufacturer()) {
            if (m.getApplicationPrograms() != null) {
                for (ApplicationProgram ap : m.getApplicationPrograms().getApplicationProgram()) {
                    if (ap.getStatic() != null && ap.getStatic().getComObjectTable() != null) {
                        for (ComObject co : ap.getStatic().getComObjectTable().getComObject()) {
                            if (comObjectRefId.equals(co.getId())) return co;
                        }
                    }
                }
            }
        }
        // Also check by ID map if it's already indexed
        Object obj = findById(comObjectRefId);
        if (obj instanceof ComObject) return (ComObject) obj;
        
        return null;
    }

    public GroupAddress findGroupAddress(String refId) {
        Object obj = findById(refId);
        if (obj instanceof GroupAddress) return (GroupAddress) obj;
        return null;
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

    public ApplicationProgram resolveApplicationProgram(DeviceInstance device) {
        if (device == null || device.getHardware2ProgramRefId() == null) return null;
        Object obj = findById(device.getHardware2ProgramRefId());
        if (obj instanceof ApplicationProgram) return (ApplicationProgram) obj;
        
        for (Map.Entry<String, Object> entry : idMap.entrySet()) {
            if (entry.getValue() instanceof ApplicationProgram) {
                if (device.getHardware2ProgramRefId().contains(entry.getKey())) {
                    return (ApplicationProgram) entry.getValue();
                }
            }
        }
        return null;
    }
}
