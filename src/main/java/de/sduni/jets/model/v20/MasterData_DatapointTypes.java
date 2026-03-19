package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData_DatapointTypes extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "DatapointType")
    private java.util.List<DatapointType> DatapointType = new java.util.ArrayList<>();

    public java.util.List<DatapointType> getDatapointType() { return DatapointType; }
    public void setDatapointType(java.util.List<DatapointType> value) { this.DatapointType = value; }
}