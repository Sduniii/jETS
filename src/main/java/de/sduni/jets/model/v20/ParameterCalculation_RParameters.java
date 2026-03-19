package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterCalculation_RParameters extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ParameterRefRef")
    private java.util.List<CalculationParameterRef> ParameterRefRef = new java.util.ArrayList<>();

    public java.util.List<CalculationParameterRef> getParameterRefRef() { return ParameterRefRef; }
    public void setParameterRefRef(java.util.List<CalculationParameterRef> value) { this.ParameterRefRef = value; }
}