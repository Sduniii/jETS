package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleDef_Arguments extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Argument")
    private java.util.List<ModuleDef_Arguments_Argument> Argument = new java.util.ArrayList<>();

    public java.util.List<ModuleDef_Arguments_Argument> getArgument() { return Argument; }
    public void setArgument(java.util.List<ModuleDef_Arguments_Argument> value) { this.Argument = value; }
}