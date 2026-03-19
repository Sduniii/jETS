package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic_BusInterfaces extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "BusInterface")
    private java.util.List<ApplicationProgramStatic_BusInterfaces_BusInterface> BusInterface = new java.util.ArrayList<>();

    public java.util.List<ApplicationProgramStatic_BusInterfaces_BusInterface> getBusInterface() { return BusInterface; }
    public void setBusInterface(java.util.List<ApplicationProgramStatic_BusInterfaces_BusInterface> value) { this.BusInterface = value; }
}