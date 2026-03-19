package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleDef_SubModuleDefs extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ModuleDef")
    private java.util.List<ModuleDef> ModuleDef = new java.util.ArrayList<>();

    public java.util.List<ModuleDef> getModuleDef() { return ModuleDef; }
    public void setModuleDef(java.util.List<ModuleDef> value) { this.ModuleDef = value; }
}