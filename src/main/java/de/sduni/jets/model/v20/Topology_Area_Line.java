package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Topology_Area_Line extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Address")
    private int Address;
    @JacksonXmlProperty(isAttribute = true, localName = "MediumTypeRefId")
    private String MediumTypeRefId;
    @JacksonXmlProperty(isAttribute = true, localName = "Comment")
    private String Comment;
    @JacksonXmlProperty(isAttribute = true, localName = "DomainAddress")
    private long DomainAddress;
    @JacksonXmlProperty(isAttribute = true, localName = "CompletionStatus")
    private String CompletionStatus;
    @JacksonXmlProperty(isAttribute = true, localName = "Description")
    private String Description;
    @JacksonXmlProperty(isAttribute = true, localName = "Puid")
    private int Puid;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "DeviceInstance")
    private java.util.List<DeviceInstance> DeviceInstance = new java.util.ArrayList<>();
    @JacksonXmlProperty(localName = "BusAccess")
    private BusAccess BusAccess = null;
    @JacksonXmlProperty(localName = "AdditionalGroupAddresses")
    private Topology_Area_Line_AdditionalGroupAddresses AdditionalGroupAddresses = null;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public int getAddress() { return Address; }
    public void setAddress(int value) { this.Address = value; }
    public String getMediumTypeRefId() { return MediumTypeRefId; }
    public void setMediumTypeRefId(String value) { this.MediumTypeRefId = value; }
    public String getComment() { return Comment; }
    public void setComment(String value) { this.Comment = value; }
    public long getDomainAddress() { return DomainAddress; }
    public void setDomainAddress(long value) { this.DomainAddress = value; }
    public String getCompletionStatus() { return CompletionStatus; }
    public void setCompletionStatus(String value) { this.CompletionStatus = value; }
    public String getDescription() { return Description; }
    public void setDescription(String value) { this.Description = value; }
    public int getPuid() { return Puid; }
    public void setPuid(int value) { this.Puid = value; }
    public java.util.List<DeviceInstance> getDeviceInstance() { return DeviceInstance; }
    public void setDeviceInstance(java.util.List<DeviceInstance> value) { this.DeviceInstance = value; }
    public BusAccess getBusAccess() { return BusAccess; }
    public void setBusAccess(BusAccess value) { this.BusAccess = value; }
    public Topology_Area_Line_AdditionalGroupAddresses getAdditionalGroupAddresses() { return AdditionalGroupAddresses; }
    public void setAdditionalGroupAddresses(Topology_Area_Line_AdditionalGroupAddresses value) { this.AdditionalGroupAddresses = value; }
}