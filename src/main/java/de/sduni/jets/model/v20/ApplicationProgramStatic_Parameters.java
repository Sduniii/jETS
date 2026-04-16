package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic_Parameters extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Parameter")
    private java.util.List<ApplicationProgramStatic_Parameters_Parameter> Parameter = new java.util.ArrayList<>();

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Union")
    private java.util.List<ApplicationProgramStatic_Parameters_Union> Union = new java.util.ArrayList<>();

    public java.util.List<ApplicationProgramStatic_Parameters_Parameter> getParameter() { return Parameter; }
    public void setParameter(java.util.List<ApplicationProgramStatic_Parameters_Parameter> value) { this.Parameter = value; }

    public java.util.List<ApplicationProgramStatic_Parameters_Union> getUnion() { return Union; }
    public void setUnion(java.util.List<ApplicationProgramStatic_Parameters_Union> value) { this.Union = value; }
}
