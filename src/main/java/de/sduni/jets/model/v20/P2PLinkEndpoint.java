package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class P2PLinkEndpoint extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "DeviceRefId")
    private String DeviceRefId;

    public String getDeviceRefId() { return DeviceRefId; }
    public void setDeviceRefId(String value) { this.DeviceRefId = value; }
}