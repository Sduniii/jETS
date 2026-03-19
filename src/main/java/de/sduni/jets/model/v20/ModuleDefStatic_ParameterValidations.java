package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleDefStatic_ParameterValidations extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ParameterValidation")
    private java.util.List<ParameterValidation> ParameterValidation = new java.util.ArrayList<>();

    public java.util.List<ParameterValidation> getParameterValidation() { return ParameterValidation; }
    public void setParameterValidation(java.util.List<ParameterValidation> value) { this.ParameterValidation = value; }
}