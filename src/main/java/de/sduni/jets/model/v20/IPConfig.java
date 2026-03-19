package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IPConfig extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Assign")
    private String Assign;
    @JacksonXmlProperty(isAttribute = true, localName = "IPAddress")
    private String IPAddress;
    @JacksonXmlProperty(isAttribute = true, localName = "SubnetMask")
    private String SubnetMask;
    @JacksonXmlProperty(isAttribute = true, localName = "DefaultGateway")
    private String DefaultGateway;
    @JacksonXmlProperty(isAttribute = true, localName = "MACAddress")
    private String MACAddress;

    public String getAssign() { return Assign; }
    public void setAssign(String value) { this.Assign = value; }
    public String getIPAddress() { return IPAddress; }
    public void setIPAddress(String value) { this.IPAddress = value; }
    public String getSubnetMask() { return SubnetMask; }
    public void setSubnetMask(String value) { this.SubnetMask = value; }
    public String getDefaultGateway() { return DefaultGateway; }
    public void setDefaultGateway(String value) { this.DefaultGateway = value; }
    public String getMACAddress() { return MACAddress; }
    public void setMACAddress(String value) { this.MACAddress = value; }
}