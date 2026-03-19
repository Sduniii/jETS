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
        }

        // 3. Deep recursion into all fields/methods
        if (obj instanceof Collection) {
            for (Object item : (Collection<?>) obj) deepIndex(item);
        } else if (obj instanceof KnxBase) {
            for (Method m : obj.getClass().getMethods()) {
                if (m.getName().startsWith("get") && m.getParameterCount() == 0 && 
                    !m.getName().equals("getClass") && !m.getName().equals("getProject")) {
                    try {
                        Object val = m.invoke(obj);
                        if (val != null) deepIndex(val);
                    } catch (Exception ignored) {}
                }
            }
        }
        
        // 4. Forced scan for projects if root
        if (obj instanceof KNX) {
            KNX k = (KNX) obj;
            if (k.getProject() != null) {
                for (Project p : k.getProject()) deepIndex(p);
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
