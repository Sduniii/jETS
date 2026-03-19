package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupAddress extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Address")
    private long Address;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Unfiltered")
    private boolean Unfiltered;
    @JacksonXmlProperty(isAttribute = true, localName = "Central")
    private boolean Central;
    @JacksonXmlProperty(isAttribute = true, localName = "Global")
    private boolean Global;
    @JacksonXmlProperty(isAttribute = true, localName = "DatapointType")
    private String DatapointType;
    @JacksonXmlProperty(isAttribute = true, localName = "Description")
    private String Description;
    @JacksonXmlProperty(isAttribute = true, localName = "Comment")
    private String Comment;
    @JacksonXmlProperty(isAttribute = true, localName = "Puid")
    private int Puid;
    @JacksonXmlProperty(isAttribute = true, localName = "Key")
    private String Key;
    @JacksonXmlProperty(isAttribute = true, localName = "Security")
    private String Security;
    @JacksonXmlProperty(isAttribute = true, localName = "Context")
    private String Context;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public long getAddress() { return Address; }
    public void setAddress(long value) { this.Address = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public boolean getUnfiltered() { return Unfiltered; }
    public void setUnfiltered(boolean value) { this.Unfiltered = value; }
    public boolean getCentral() { return Central; }
    public void setCentral(boolean value) { this.Central = value; }
    public boolean getGlobal() { return Global; }
    public void setGlobal(boolean value) { this.Global = value; }
    public String getDatapointType() { return DatapointType; }
    public void setDatapointType(String value) { this.DatapointType = value; }
    public String getDescription() { return Description; }
    public void setDescription(String value) { this.Description = value; }
    public String getComment() { return Comment; }
    public void setComment(String value) { this.Comment = value; }
    public int getPuid() { return Puid; }
    public void setPuid(int value) { this.Puid = value; }
    public String getKey() { return Key; }
    public void setKey(String value) { this.Key = value; }
    public String getSecurity() { return Security; }
    public void setSecurity(String value) { this.Security = value; }
    public String getContext() { return Context; }
    public void setContext(String value) { this.Context = value; }
}