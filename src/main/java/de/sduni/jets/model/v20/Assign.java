package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Assign extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "TargetParamRefRef")
    private String TargetParamRefRef;
    @JacksonXmlProperty(isAttribute = true, localName = "SourceParamRefRef")
    private String SourceParamRefRef;
    @JacksonXmlProperty(isAttribute = true, localName = "Value")
    private String Value;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;

    public String getTargetParamRefRef() { return TargetParamRefRef; }
    public void setTargetParamRefRef(String value) { this.TargetParamRefRef = value; }
    public String getSourceParamRefRef() { return SourceParamRefRef; }
    public void setSourceParamRefRef(String value) { this.SourceParamRefRef = value; }
    public String getValue() { return Value; }
    public void setValue(String value) { this.Value = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
}