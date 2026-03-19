package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ManufacturerData_Manufacturer_Catalog extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "CatalogSection")
    private java.util.List<CatalogSection> CatalogSection = new java.util.ArrayList<>();

    public java.util.List<CatalogSection> getCatalogSection() { return CatalogSection; }
    public void setCatalogSection(java.util.List<CatalogSection> value) { this.CatalogSection = value; }
}