package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hardware_Hardware2Programs extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Hardware2Program")
    private java.util.List<Hardware2Program> Hardware2Program = new java.util.ArrayList<>();

    public java.util.List<Hardware2Program> getHardware2Program() { return Hardware2Program; }
    public void setHardware2Program(java.util.List<Hardware2Program> value) { this.Hardware2Program = value; }
}