package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic_FixupList extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Fixup")
    private java.util.List<Fixup> Fixup = new java.util.ArrayList<>();

    public java.util.List<Fixup> getFixup() { return Fixup; }
    public void setFixup(java.util.List<Fixup> value) { this.Fixup = value; }
}