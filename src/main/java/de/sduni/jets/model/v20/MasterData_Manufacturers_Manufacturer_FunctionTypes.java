package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData_Manufacturers_Manufacturer_FunctionTypes extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "FunctionsGroup")
    private java.util.List<FunctionsGroup> FunctionsGroup = new java.util.ArrayList<>();
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "FunctionType")
    private java.util.List<FunctionType> FunctionType = new java.util.ArrayList<>();

    public java.util.List<FunctionsGroup> getFunctionsGroup() { return FunctionsGroup; }
    public void setFunctionsGroup(java.util.List<FunctionsGroup> value) { this.FunctionsGroup = value; }
    public java.util.List<FunctionType> getFunctionType() { return FunctionType; }
    public void setFunctionType(java.util.List<FunctionType> value) { this.FunctionType = value; }
}