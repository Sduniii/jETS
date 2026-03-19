package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class P2PLinkDeviceEndpoint extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "DeviceRefId")
    private String DeviceRefId;
    @JacksonXmlProperty(isAttribute = true, localName = "SecurityRoles")
    private String SecurityRoles;

    public String getDeviceRefId() { return DeviceRefId; }
    public void setDeviceRefId(String value) { this.DeviceRefId = value; }
    public String getSecurityRoles() { return SecurityRoles; }
    public void setSecurityRoles(String value) { this.SecurityRoles = value; }
}