package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Function extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Type")
    private String Type;
    @JacksonXmlProperty(isAttribute = true, localName = "Implements")
    private String Implements;
    @JacksonXmlProperty(isAttribute = true, localName = "Number")
    private String Number;
    @JacksonXmlProperty(isAttribute = true, localName = "Comment")
    private String Comment;
    @JacksonXmlProperty(isAttribute = true, localName = "Description")
    private String Description;
    @JacksonXmlProperty(isAttribute = true, localName = "CompletionStatus")
    private String CompletionStatus;
    @JacksonXmlProperty(isAttribute = true, localName = "DefaultGroupRange")
    private String DefaultGroupRange;
    @JacksonXmlProperty(isAttribute = true, localName = "Puid")
    private int Puid;
    @JacksonXmlProperty(isAttribute = true, localName = "Context")
    private String Context;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "GroupAddressRef")
    private java.util.List<GroupAddressRef> GroupAddressRef = new java.util.ArrayList<>();

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getType() { return Type; }
    public void setType(String value) { this.Type = value; }
    public String getImplements() { return Implements; }
    public void setImplements(String value) { this.Implements = value; }
    public String getNumber() { return Number; }
    public void setNumber(String value) { this.Number = value; }
    public String getComment() { return Comment; }
    public void setComment(String value) { this.Comment = value; }
    public String getDescription() { return Description; }
    public void setDescription(String value) { this.Description = value; }
    public String getCompletionStatus() { return CompletionStatus; }
    public void setCompletionStatus(String value) { this.CompletionStatus = value; }
    public String getDefaultGroupRange() { return DefaultGroupRange; }
    public void setDefaultGroupRange(String value) { this.DefaultGroupRange = value; }
    public int getPuid() { return Puid; }
    public void setPuid(int value) { this.Puid = value; }
    public String getContext() { return Context; }
    public void setContext(String value) { this.Context = value; }
    public java.util.List<GroupAddressRef> getGroupAddressRef() { return GroupAddressRef; }
    public void setGroupAddressRef(java.util.List<GroupAddressRef> value) { this.GroupAddressRef = value; }
}