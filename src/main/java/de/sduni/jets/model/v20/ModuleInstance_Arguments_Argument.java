package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleInstance_Arguments_Argument extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "RefId")
    private String RefId;
    @JacksonXmlProperty(isAttribute = true, localName = "Value")
    private String Value;

    public String getRefId() { return RefId; }
    public void setRefId(String value) { this.RefId = value; }
    public String getValue() { return Value; }
    public void setValue(String value) { this.Value = value; }
}