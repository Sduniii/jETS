package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HawkConfigurationData_InterfaceObjects_InterfaceObject_Property extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "PropertyID")
    private int PropertyID;
    @JacksonXmlProperty(isAttribute = true, localName = "PropertyDataType")
    private String PropertyDataType;

    public int getPropertyID() { return PropertyID; }
    public void setPropertyID(int value) { this.PropertyID = value; }
    public String getPropertyDataType() { return PropertyDataType; }
    public void setPropertyDataType(String value) { this.PropertyDataType = value; }
}