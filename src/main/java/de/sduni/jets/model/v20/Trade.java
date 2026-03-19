package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Trade extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Number")
    private String Number;
    @JacksonXmlProperty(isAttribute = true, localName = "Comment")
    private String Comment;
    @JacksonXmlProperty(isAttribute = true, localName = "CompletionStatus")
    private String CompletionStatus;
    @JacksonXmlProperty(isAttribute = true, localName = "Description")
    private String Description;
    @JacksonXmlProperty(isAttribute = true, localName = "Puid")
    private int Puid;
    @JacksonXmlProperty(isAttribute = true, localName = "Context")
    private String Context;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Trade")
    private java.util.List<Trade> Trade = new java.util.ArrayList<>();
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "DeviceInstanceRef")
    private java.util.List<DeviceInstanceRef> DeviceInstanceRef = new java.util.ArrayList<>();

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getNumber() { return Number; }
    public void setNumber(String value) { this.Number = value; }
    public String getComment() { return Comment; }
    public void setComment(String value) { this.Comment = value; }
    public String getCompletionStatus() { return CompletionStatus; }
    public void setCompletionStatus(String value) { this.CompletionStatus = value; }
    public String getDescription() { return Description; }
    public void setDescription(String value) { this.Description = value; }
    public int getPuid() { return Puid; }
    public void setPuid(int value) { this.Puid = value; }
    public String getContext() { return Context; }
    public void setContext(String value) { this.Context = value; }
    public java.util.List<Trade> getTrade() { return Trade; }
    public void setTrade(java.util.List<Trade> value) { this.Trade = value; }
    public java.util.List<DeviceInstanceRef> getDeviceInstanceRef() { return DeviceInstanceRef; }
    public void setDeviceInstanceRef(java.util.List<DeviceInstanceRef> value) { this.DeviceInstanceRef = value; }
}