package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ManufacturerData_Manufacturer_Hardware extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Hardware")
    private java.util.List<Hardware> Hardware = new java.util.ArrayList<>();

    public java.util.List<Hardware> getHardware() { return Hardware; }
    public void setHardware(java.util.List<Hardware> value) { this.Hardware = value; }
}