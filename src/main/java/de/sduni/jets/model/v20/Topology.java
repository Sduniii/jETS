package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Topology extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Area")
    private java.util.List<Topology_Area> Area = new java.util.ArrayList<>();
    @JacksonXmlProperty(localName = "UnassignedDevices")
    private Topology_UnassignedDevices UnassignedDevices = null;

    public java.util.List<Topology_Area> getArea() { return Area; }
    public void setArea(java.util.List<Topology_Area> value) { this.Area = value; }
    public Topology_UnassignedDevices getUnassignedDevices() { return UnassignedDevices; }
    public void setUnassignedDevices(Topology_UnassignedDevices value) { this.UnassignedDevices = value; }
}