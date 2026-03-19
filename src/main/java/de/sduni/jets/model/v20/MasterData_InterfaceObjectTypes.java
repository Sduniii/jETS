package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData_InterfaceObjectTypes extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "InterfaceObjectType")
    private java.util.List<MasterData_InterfaceObjectTypes_InterfaceObjectType> InterfaceObjectType = new java.util.ArrayList<>();

    public java.util.List<MasterData_InterfaceObjectTypes_InterfaceObjectType> getInterfaceObjectType() { return InterfaceObjectType; }
    public void setInterfaceObjectType(java.util.List<MasterData_InterfaceObjectTypes_InterfaceObjectType> value) { this.InterfaceObjectType = value; }
}