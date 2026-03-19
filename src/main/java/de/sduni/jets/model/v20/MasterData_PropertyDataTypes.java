package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData_PropertyDataTypes extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "PropertyDataType")
    private java.util.List<MasterData_PropertyDataTypes_PropertyDataType> PropertyDataType = new java.util.ArrayList<>();

    public java.util.List<MasterData_PropertyDataTypes_PropertyDataType> getPropertyDataType() { return PropertyDataType; }
    public void setPropertyDataType(java.util.List<MasterData_PropertyDataTypes_PropertyDataType> value) { this.PropertyDataType = value; }
}