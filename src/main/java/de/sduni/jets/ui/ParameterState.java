package de.sduni.jets.ui;

import de.sduni.jets.model.v20.*;
import java.util.*;
import java.util.function.Consumer;

/**
 * Manages the current parameter values for a device and notifies listeners of changes.
 */
public class ParameterState {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ParameterState.class);
    private final Map<String, String> values = new HashMap<>();
    private final List<Consumer<String>> listeners = new ArrayList<>();

    public ParameterState(DeviceInstance di) {
        if (di.getParameterInstanceRefs() != null) {
            for (ParameterInstanceRef pir : di.getParameterInstanceRefs().getParameterInstanceRef()) {
                values.put(pir.getRefId(), pir.getValue());
                // Also store without R- suffix if present
                if (pir.getRefId().contains("_R-")) {
                    String baseId = pir.getRefId().substring(0, pir.getRefId().lastIndexOf("_R-"));
                    if (!values.containsKey(baseId)) {
                        values.put(baseId, pir.getValue());
                    }
                }
            }
        }
        logger.debug("Initialized ParameterState with {} values.", values.size());
    }

    public String getValue(String paramRefId) {
        if (paramRefId == null) return null;
        String val = values.get(paramRefId);
        if (val != null) return val;
        
        // Fallback: if we look for base ID but only have R- suffixed IDs in map
        for (Map.Entry<String, String> entry : values.entrySet()) {
            if (entry.getKey().startsWith(paramRefId + "_R-")) {
                return entry.getValue();
            }
        }
        
        return null;
    }

    public void setValue(String paramRefId, String value) {
        values.put(paramRefId, value);
        notifyListeners(paramRefId);
    }

    public void addListener(Consumer<String> listener) {
        listeners.add(listener);
    }

    private void notifyListeners(String paramRefId) {
        for (Consumer<String> l : listeners) {
            l.accept(paramRefId);
        }
    }
}
