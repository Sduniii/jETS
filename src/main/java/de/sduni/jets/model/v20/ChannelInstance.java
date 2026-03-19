package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelInstance extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "RefId")
    private String RefId;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Description")
    private String Description;
    @JacksonXmlProperty(isAttribute = true, localName = "IsActive")
    private boolean IsActive;
    @JacksonXmlProperty(isAttribute = true, localName = "Context")
    private String Context;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getRefId() { return RefId; }
    public void setRefId(String value) { this.RefId = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getDescription() { return Description; }
    public void setDescription(String value) { this.Description = value; }
    public boolean getIsActive() { return IsActive; }
    public void setIsActive(boolean value) { this.IsActive = value; }
    public String getContext() { return Context; }
    public void setContext(String value) { this.Context = value; }
}