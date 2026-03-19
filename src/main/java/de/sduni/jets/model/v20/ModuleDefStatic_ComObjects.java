package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleDefStatic_ComObjects extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ComObject")
    private java.util.List<ModuleDefStatic_ComObjects_ComObject> ComObject = new java.util.ArrayList<>();

    public java.util.List<ModuleDefStatic_ComObjects_ComObject> getComObject() { return ComObject; }
    public void setComObject(java.util.List<ModuleDefStatic_ComObjects_ComObject> value) { this.ComObject = value; }
}