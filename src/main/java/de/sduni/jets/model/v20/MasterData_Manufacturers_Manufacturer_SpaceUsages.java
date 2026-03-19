package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData_Manufacturers_Manufacturer_SpaceUsages extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "SpaceUsage")
    private java.util.List<SpaceUsage> SpaceUsage = new java.util.ArrayList<>();

    public java.util.List<SpaceUsage> getSpaceUsage() { return SpaceUsage; }
    public void setSpaceUsage(java.util.List<SpaceUsage> value) { this.SpaceUsage = value; }
}