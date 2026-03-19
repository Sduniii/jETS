package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleInstance extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "RefId")
    private String RefId;
    @JacksonXmlProperty(isAttribute = true, localName = "RepeatIndex")
    private String RepeatIndex;
    @JacksonXmlProperty(localName = "Arguments")
    private ModuleInstance_Arguments Arguments = null;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getRefId() { return RefId; }
    public void setRefId(String value) { this.RefId = value; }
    public String getRepeatIndex() { return RepeatIndex; }
    public void setRepeatIndex(String value) { this.RepeatIndex = value; }
    public ModuleInstance_Arguments getArguments() { return Arguments; }
    public void setArguments(ModuleInstance_Arguments value) { this.Arguments = value; }
}