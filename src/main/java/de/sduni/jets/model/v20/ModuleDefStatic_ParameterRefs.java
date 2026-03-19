package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleDefStatic_ParameterRefs extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ParameterRef")
    private java.util.List<ParameterRef> ParameterRef = new java.util.ArrayList<>();

    public java.util.List<ParameterRef> getParameterRef() { return ParameterRef; }
    public void setParameterRef(java.util.List<ParameterRef> value) { this.ParameterRef = value; }
}