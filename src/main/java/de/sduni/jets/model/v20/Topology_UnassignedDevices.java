package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Topology_UnassignedDevices extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "DeviceInstance")
    private java.util.List<DeviceInstance> DeviceInstance = new java.util.ArrayList<>();

    public java.util.List<DeviceInstance> getDeviceInstance() { return DeviceInstance; }
    public void setDeviceInstance(java.util.List<DeviceInstance> value) { this.DeviceInstance = value; }
}