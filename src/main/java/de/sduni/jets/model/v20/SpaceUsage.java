package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpaceUsage extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Number")
    private long Number;
    @JacksonXmlProperty(isAttribute = true, localName = "Text")
    private String Text;
    @JacksonXmlProperty(isAttribute = true, localName = "Description")
    private String Description;
    @JacksonXmlProperty(isAttribute = true, localName = "Relations")
    private String Relations;
    @JacksonXmlProperty(isAttribute = true, localName = "Status")
    private String Status;
    @JacksonXmlProperty(isAttribute = true, localName = "Semantics")
    private String Semantics;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "SpaceUsage")
    private java.util.List<SpaceUsage> SpaceUsage = new java.util.ArrayList<>();

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public long getNumber() { return Number; }
    public void setNumber(long value) { this.Number = value; }
    public String getText() { return Text; }
    public void setText(String value) { this.Text = value; }
    public String getDescription() { return Description; }
    public void setDescription(String value) { this.Description = value; }
    public String getRelations() { return Relations; }
    public void setRelations(String value) { this.Relations = value; }
    public String getStatus() { return Status; }
    public void setStatus(String value) { this.Status = value; }
    public String getSemantics() { return Semantics; }
    public void setSemantics(String value) { this.Semantics = value; }
    public java.util.List<SpaceUsage> getSpaceUsage() { return SpaceUsage; }
    public void setSpaceUsage(java.util.List<SpaceUsage> value) { this.SpaceUsage = value; }
}