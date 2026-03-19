package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Topology_Area extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Address")
    private int Address;
    @JacksonXmlProperty(isAttribute = true, localName = "Comment")
    private String Comment;
    @JacksonXmlProperty(isAttribute = true, localName = "CompletionStatus")
    private String CompletionStatus;
    @JacksonXmlProperty(isAttribute = true, localName = "Description")
    private String Description;
    @JacksonXmlProperty(isAttribute = true, localName = "Puid")
    private int Puid;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Line")
    private java.util.List<Topology_Area_Line> Line = new java.util.ArrayList<>();

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public int getAddress() { return Address; }
    public void setAddress(int value) { this.Address = value; }
    public String getComment() { return Comment; }
    public void setComment(String value) { this.Comment = value; }
    public String getCompletionStatus() { return CompletionStatus; }
    public void setCompletionStatus(String value) { this.CompletionStatus = value; }
    public String getDescription() { return Description; }
    public void setDescription(String value) { this.Description = value; }
    public int getPuid() { return Puid; }
    public void setPuid(int value) { this.Puid = value; }
    public java.util.List<Topology_Area_Line> getLine() { return Line; }
    public void setLine(java.util.List<Topology_Area_Line> value) { this.Line = value; }
}