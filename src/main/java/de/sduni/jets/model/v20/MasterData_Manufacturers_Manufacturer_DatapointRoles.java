package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData_Manufacturers_Manufacturer_DatapointRoles extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "DatapointRole")
    private java.util.List<DatapointRole> DatapointRole = new java.util.ArrayList<>();

    public java.util.List<DatapointRole> getDatapointRole() { return DatapointRole; }
    public void setDatapointRole(java.util.List<DatapointRole> value) { this.DatapointRole = value; }
}