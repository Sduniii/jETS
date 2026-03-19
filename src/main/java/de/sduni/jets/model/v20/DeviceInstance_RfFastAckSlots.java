package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceInstance_RfFastAckSlots extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Slot")
    private java.util.List<DeviceInstance_RfFastAckSlots_Slot> Slot = new java.util.ArrayList<>();

    public java.util.List<DeviceInstance_RfFastAckSlots_Slot> getSlot() { return Slot; }
    public void setSlot(java.util.List<DeviceInstance_RfFastAckSlots_Slot> value) { this.Slot = value; }
}