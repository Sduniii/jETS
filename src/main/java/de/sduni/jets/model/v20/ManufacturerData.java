package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ManufacturerData extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Manufacturer")
    private java.util.List<ManufacturerData_Manufacturer> Manufacturer = new java.util.ArrayList<>();

    public java.util.List<ManufacturerData_Manufacturer> getManufacturer() { return Manufacturer; }
    public void setManufacturer(java.util.List<ManufacturerData_Manufacturer> value) { this.Manufacturer = value; }
}