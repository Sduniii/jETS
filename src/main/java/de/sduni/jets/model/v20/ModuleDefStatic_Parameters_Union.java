package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleDefStatic_Parameters_Union extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "SizeInBit")
    private long SizeInBit;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Parameter")
    private java.util.List<UnionParameter> Parameter = new java.util.ArrayList<>();

    public long getSizeInBit() { return SizeInBit; }
    public void setSizeInBit(long value) { this.SizeInBit = value; }
    public java.util.List<UnionParameter> getParameter() { return Parameter; }
    public void setParameter(java.util.List<UnionParameter> value) { this.Parameter = value; }
}