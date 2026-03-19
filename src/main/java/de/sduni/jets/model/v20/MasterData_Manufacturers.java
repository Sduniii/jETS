package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData_Manufacturers extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Manufacturer")
    private java.util.List<MasterData_Manufacturers_Manufacturer> Manufacturer = new java.util.ArrayList<>();

    public java.util.List<MasterData_Manufacturers_Manufacturer> getManufacturer() { return Manufacturer; }
    public void setManufacturer(java.util.List<MasterData_Manufacturers_Manufacturer> value) { this.Manufacturer = value; }
}