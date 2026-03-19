package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Security extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "LoadedIPRoutingBackboneKey")
    private String LoadedIPRoutingBackboneKey;
    @JacksonXmlProperty(isAttribute = true, localName = "DeviceAuthenticationCode")
    private String DeviceAuthenticationCode;
    @JacksonXmlProperty(isAttribute = true, localName = "DeviceAuthenticationCodeHash")
    private byte[] DeviceAuthenticationCodeHash;
    @JacksonXmlProperty(isAttribute = true, localName = "LoadedDeviceAuthenticationCodeHash")
    private byte[] LoadedDeviceAuthenticationCodeHash;
    @JacksonXmlProperty(isAttribute = true, localName = "DeviceManagementPassword")
    private String DeviceManagementPassword;
    @JacksonXmlProperty(isAttribute = true, localName = "DeviceManagementPasswordHash")
    private byte[] DeviceManagementPasswordHash;
    @JacksonXmlProperty(isAttribute = true, localName = "LoadedDeviceManagementPasswordHash")
    private byte[] LoadedDeviceManagementPasswordHash;
    @JacksonXmlProperty(isAttribute = true, localName = "ToolKey")
    private String ToolKey;
    @JacksonXmlProperty(isAttribute = true, localName = "LoadedToolKey")
    private String LoadedToolKey;
    @JacksonXmlProperty(isAttribute = true, localName = "SequenceNumber")
    private long SequenceNumber;
    @JacksonXmlProperty(isAttribute = true, localName = "SequenceNumberTimestamp")
    private java.time.LocalDateTime SequenceNumberTimestamp;

    public String getLoadedIPRoutingBackboneKey() { return LoadedIPRoutingBackboneKey; }
    public void setLoadedIPRoutingBackboneKey(String value) { this.LoadedIPRoutingBackboneKey = value; }
    public String getDeviceAuthenticationCode() { return DeviceAuthenticationCode; }
    public void setDeviceAuthenticationCode(String value) { this.DeviceAuthenticationCode = value; }
    public byte[] getDeviceAuthenticationCodeHash() { return DeviceAuthenticationCodeHash; }
    public void setDeviceAuthenticationCodeHash(byte[] value) { this.DeviceAuthenticationCodeHash = value; }
    public byte[] getLoadedDeviceAuthenticationCodeHash() { return LoadedDeviceAuthenticationCodeHash; }
    public void setLoadedDeviceAuthenticationCodeHash(byte[] value) { this.LoadedDeviceAuthenticationCodeHash = value; }
    public String getDeviceManagementPassword() { return DeviceManagementPassword; }
    public void setDeviceManagementPassword(String value) { this.DeviceManagementPassword = value; }
    public byte[] getDeviceManagementPasswordHash() { return DeviceManagementPasswordHash; }
    public void setDeviceManagementPasswordHash(byte[] value) { this.DeviceManagementPasswordHash = value; }
    public byte[] getLoadedDeviceManagementPasswordHash() { return LoadedDeviceManagementPasswordHash; }
    public void setLoadedDeviceManagementPasswordHash(byte[] value) { this.LoadedDeviceManagementPasswordHash = value; }
    public String getToolKey() { return ToolKey; }
    public void setToolKey(String value) { this.ToolKey = value; }
    public String getLoadedToolKey() { return LoadedToolKey; }
    public void setLoadedToolKey(String value) { this.LoadedToolKey = value; }
    public long getSequenceNumber() { return SequenceNumber; }
    public void setSequenceNumber(long value) { this.SequenceNumber = value; }
    public java.time.LocalDateTime getSequenceNumberTimestamp() { return SequenceNumberTimestamp; }
    public void setSequenceNumberTimestamp(java.time.LocalDateTime value) { this.SequenceNumberTimestamp = value; }
}