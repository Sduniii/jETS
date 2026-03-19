package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class P2PLinkBusInterfaceEndpoint extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "DeviceRefId")
    private String DeviceRefId;
    @JacksonXmlProperty(isAttribute = true, localName = "BusInterfaceRefId")
    private String BusInterfaceRefId;

    public String getDeviceRefId() { return DeviceRefId; }
    public void setDeviceRefId(String value) { this.DeviceRefId = value; }
    public String getBusInterfaceRefId() { return BusInterfaceRefId; }
    public void setBusInterfaceRefId(String value) { this.BusInterfaceRefId = value; }
}