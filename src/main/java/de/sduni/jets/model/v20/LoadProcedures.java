package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoadProcedures extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "LoadProcedure")
    private java.util.List<LoadProcedures_LoadProcedure> LoadProcedure = new java.util.ArrayList<>();

    public java.util.List<LoadProcedures_LoadProcedure> getLoadProcedure() { return LoadProcedure; }
    public void setLoadProcedure(java.util.List<LoadProcedures_LoadProcedure> value) { this.LoadProcedure = value; }
}