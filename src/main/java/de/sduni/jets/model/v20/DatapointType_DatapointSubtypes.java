package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatapointType_DatapointSubtypes extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "DatapointSubtype")
    private java.util.List<DatapointType_DatapointSubtypes_DatapointSubtype> DatapointSubtype = new java.util.ArrayList<>();

    public java.util.List<DatapointType_DatapointSubtypes_DatapointSubtype> getDatapointSubtype() { return DatapointSubtype; }
    public void setDatapointSubtype(java.util.List<DatapointType_DatapointSubtypes_DatapointSubtype> value) { this.DatapointSubtype = value; }
}