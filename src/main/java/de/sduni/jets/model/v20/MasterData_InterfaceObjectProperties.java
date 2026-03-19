package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData_InterfaceObjectProperties extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "InterfaceObjectProperty")
    private java.util.List<MasterData_InterfaceObjectProperties_InterfaceObjectProperty> InterfaceObjectProperty = new java.util.ArrayList<>();

    public java.util.List<MasterData_InterfaceObjectProperties_InterfaceObjectProperty> getInterfaceObjectProperty() { return InterfaceObjectProperty; }
    public void setInterfaceObjectProperty(java.util.List<MasterData_InterfaceObjectProperties_InterfaceObjectProperty> value) { this.InterfaceObjectProperty = value; }
}