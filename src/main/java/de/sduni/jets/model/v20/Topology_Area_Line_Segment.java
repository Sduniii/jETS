package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Topology_Area_Line_Segment extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Number")
    private int Number;
    @JacksonXmlProperty(isAttribute = true, localName = "MediumTypeRefId")
    private String MediumTypeRefId;
    @JacksonXmlProperty(isAttribute = true, localName = "Puid")
    private int Puid;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "DeviceInstance")
    private java.util.List<DeviceInstance> DeviceInstance = new java.util.ArrayList<>();

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public int getNumber() { return Number; }
    public void setNumber(int value) { this.Number = value; }
    public String getMediumTypeRefId() { return MediumTypeRefId; }
    public void setMediumTypeRefId(String value) { this.MediumTypeRefId = value; }
    public int getPuid() { return Puid; }
    public void setPuid(int value) { this.Puid = value; }
    public java.util.List<DeviceInstance> getDeviceInstance() { return DeviceInstance; }
    public void setDeviceInstance(java.util.List<DeviceInstance> value) { this.DeviceInstance = value; }
}
