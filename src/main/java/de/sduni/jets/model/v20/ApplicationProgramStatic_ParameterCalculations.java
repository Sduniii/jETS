package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic_ParameterCalculations extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ParameterCalculation")
    private java.util.List<ParameterCalculation> ParameterCalculation = new java.util.ArrayList<>();

    public java.util.List<ParameterCalculation> getParameterCalculation() { return ParameterCalculation; }
    public void setParameterCalculation(java.util.List<ParameterCalculation> value) { this.ParameterCalculation = value; }
}