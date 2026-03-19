package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData_FunctionalBlocks_FunctionalBlock_Parameters extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "ObjectType")
    private String ObjectType;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Parameter")
    private java.util.List<MasterData_FunctionalBlocks_FunctionalBlock_Parameters_Parameter> Parameter = new java.util.ArrayList<>();

    public String getObjectType() { return ObjectType; }
    public void setObjectType(String value) { this.ObjectType = value; }
    public java.util.List<MasterData_FunctionalBlocks_FunctionalBlock_Parameters_Parameter> getParameter() { return Parameter; }
    public void setParameter(java.util.List<MasterData_FunctionalBlocks_FunctionalBlock_Parameters_Parameter> value) { this.Parameter = value; }
}