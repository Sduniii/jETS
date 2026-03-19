package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceInstance_BinaryData extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "BinaryData")
    private java.util.List<DeviceInstance_BinaryData_BinaryData> BinaryData = new java.util.ArrayList<>();

    public java.util.List<DeviceInstance_BinaryData_BinaryData> getBinaryData() { return BinaryData; }
    public void setBinaryData(java.util.List<DeviceInstance_BinaryData_BinaryData> value) { this.BinaryData = value; }
}