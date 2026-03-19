package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Space extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Type")
    private String Type;
    @JacksonXmlProperty(isAttribute = true, localName = "Usage")
    private String Usage;
    @JacksonXmlProperty(isAttribute = true, localName = "Number")
    private String Number;
    @JacksonXmlProperty(isAttribute = true, localName = "Comment")
    private String Comment;
    @JacksonXmlProperty(isAttribute = true, localName = "Description")
    private String Description;
    @JacksonXmlProperty(isAttribute = true, localName = "CompletionStatus")
    private String CompletionStatus;
    @JacksonXmlProperty(isAttribute = true, localName = "DefaultLine")
    private String DefaultLine;
    @JacksonXmlProperty(isAttribute = true, localName = "Puid")
    private int Puid;
    @JacksonXmlProperty(isAttribute = true, localName = "Context")
    private String Context;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Space")
    private java.util.List<Space> Space = new java.util.ArrayList<>();
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "DeviceInstanceRef")
    private java.util.List<DeviceInstanceRef> DeviceInstanceRef = new java.util.ArrayList<>();
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Function")
    private java.util.List<Function> Function = new java.util.ArrayList<>();

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getType() { return Type; }
    public void setType(String value) { this.Type = value; }
    public String getUsage() { return Usage; }
    public void setUsage(String value) { this.Usage = value; }
    public String getNumber() { return Number; }
    public void setNumber(String value) { this.Number = value; }
    public String getComment() { return Comment; }
    public void setComment(String value) { this.Comment = value; }
    public String getDescription() { return Description; }
    public void setDescription(String value) { this.Description = value; }
    public String getCompletionStatus() { return CompletionStatus; }
    public void setCompletionStatus(String value) { this.CompletionStatus = value; }
    public String getDefaultLine() { return DefaultLine; }
    public void setDefaultLine(String value) { this.DefaultLine = value; }
    public int getPuid() { return Puid; }
    public void setPuid(int value) { this.Puid = value; }
    public String getContext() { return Context; }
    public void setContext(String value) { this.Context = value; }
    public java.util.List<Space> getSpace() { return Space; }
    public void setSpace(java.util.List<Space> value) { this.Space = value; }
    public java.util.List<DeviceInstanceRef> getDeviceInstanceRef() { return DeviceInstanceRef; }
    public void setDeviceInstanceRef(java.util.List<DeviceInstanceRef> value) { this.DeviceInstanceRef = value; }
    public java.util.List<Function> getFunction() { return Function; }
    public void setFunction(java.util.List<Function> value) { this.Function = value; }
}