package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupRange extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "RangeStart")
    private int RangeStart;
    @JacksonXmlProperty(isAttribute = true, localName = "RangeEnd")
    private int RangeEnd;
    @JacksonXmlProperty(isAttribute = true, localName = "Unfiltered")
    private boolean Unfiltered;
    @JacksonXmlProperty(isAttribute = true, localName = "Description")
    private String Description;
    @JacksonXmlProperty(isAttribute = true, localName = "Comment")
    private String Comment;
    @JacksonXmlProperty(isAttribute = true, localName = "Puid")
    private int Puid;
    @JacksonXmlProperty(isAttribute = true, localName = "Security")
    private String Security;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "GroupRange")
    private java.util.List<GroupRange> GroupRange = new java.util.ArrayList<>();
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "GroupAddress")
    private java.util.List<GroupAddress> GroupAddress = new java.util.ArrayList<>();

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public int getRangeStart() { return RangeStart; }
    public void setRangeStart(int value) { this.RangeStart = value; }
    public int getRangeEnd() { return RangeEnd; }
    public void setRangeEnd(int value) { this.RangeEnd = value; }
    public boolean getUnfiltered() { return Unfiltered; }
    public void setUnfiltered(boolean value) { this.Unfiltered = value; }
    public String getDescription() { return Description; }
    public void setDescription(String value) { this.Description = value; }
    public String getComment() { return Comment; }
    public void setComment(String value) { this.Comment = value; }
    public int getPuid() { return Puid; }
    public void setPuid(int value) { this.Puid = value; }
    public String getSecurity() { return Security; }
    public void setSecurity(String value) { this.Security = value; }
    public java.util.List<GroupRange> getGroupRange() { return GroupRange; }
    public void setGroupRange(java.util.List<GroupRange> value) { this.GroupRange = value; }
    public java.util.List<GroupAddress> getGroupAddress() { return GroupAddress; }
    public void setGroupAddress(java.util.List<GroupAddress> value) { this.GroupAddress = value; }
}