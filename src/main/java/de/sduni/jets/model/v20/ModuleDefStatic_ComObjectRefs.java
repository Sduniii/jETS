package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleDefStatic_ComObjectRefs extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ComObjectRef")
    private java.util.List<ComObjectRef> ComObjectRef = new java.util.ArrayList<>();

    public java.util.List<ComObjectRef> getComObjectRef() { return ComObjectRef; }
    public void setComObjectRef(java.util.List<ComObjectRef> value) { this.ComObjectRef = value; }
}