package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatapointType_DatapointSubtypes_DatapointSubtype_Format_Enumeration extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Width")
    private long Width;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "EnumValue")
    private java.util.List<DatapointType_DatapointSubtypes_DatapointSubtype_Format_Enumeration_EnumValue> EnumValue = new java.util.ArrayList<>();

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public long getWidth() { return Width; }
    public void setWidth(long value) { this.Width = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public java.util.List<DatapointType_DatapointSubtypes_DatapointSubtype_Format_Enumeration_EnumValue> getEnumValue() { return EnumValue; }
    public void setEnumValue(java.util.List<DatapointType_DatapointSubtypes_DatapointSubtype_Format_Enumeration_EnumValue> value) { this.EnumValue = value; }
}