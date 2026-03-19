package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HawkConfigurationData_InterfaceObjects extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "InterfaceObject")
    private java.util.List<HawkConfigurationData_InterfaceObjects_InterfaceObject> InterfaceObject = new java.util.ArrayList<>();

    public java.util.List<HawkConfigurationData_InterfaceObjects_InterfaceObject> getInterfaceObject() { return InterfaceObject; }
    public void setInterfaceObject(java.util.List<HawkConfigurationData_InterfaceObjects_InterfaceObject> value) { this.InterfaceObject = value; }
}