package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HawkConfigurationData_InterfaceObjects_InterfaceObject extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Index")
    private short Index;
    @JacksonXmlProperty(isAttribute = true, localName = "ObjectType")
    private int ObjectType;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Property")
    private java.util.List<HawkConfigurationData_InterfaceObjects_InterfaceObject_Property> Property = new java.util.ArrayList<>();

    public short getIndex() { return Index; }
    public void setIndex(short value) { this.Index = value; }
    public int getObjectType() { return ObjectType; }
    public void setObjectType(int value) { this.ObjectType = value; }
    public java.util.List<HawkConfigurationData_InterfaceObjects_InterfaceObject_Property> getProperty() { return Property; }
    public void setProperty(java.util.List<HawkConfigurationData_InterfaceObjects_InterfaceObject_Property> value) { this.Property = value; }
}