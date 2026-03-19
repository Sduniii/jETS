package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleDefLoadProcedures extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "LoadProcedure")
    private java.util.List<ModuleDefLoadProcedure> LoadProcedure = new java.util.ArrayList<>();

    public java.util.List<ModuleDefLoadProcedure> getLoadProcedure() { return LoadProcedure; }
    public void setLoadProcedure(java.util.List<ModuleDefLoadProcedure> value) { this.LoadProcedure = value; }
}