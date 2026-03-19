package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic_ParameterTypes extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ParameterType")
    private java.util.List<ParameterType> ParameterType = new java.util.ArrayList<>();

    public java.util.List<ParameterType> getParameterType() { return ParameterType; }
    public void setParameterType(java.util.List<ParameterType> value) { this.ParameterType = value; }
}