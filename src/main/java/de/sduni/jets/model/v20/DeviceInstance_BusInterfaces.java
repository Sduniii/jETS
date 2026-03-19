package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceInstance_BusInterfaces extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "BusInterface")
    private java.util.List<BusInterface> BusInterface = new java.util.ArrayList<>();

    public java.util.List<BusInterface> getBusInterface() { return BusInterface; }
    public void setBusInterface(java.util.List<BusInterface> value) { this.BusInterface = value; }
}