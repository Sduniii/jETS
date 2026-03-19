package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData_FunctionalBlocks_FunctionalBlock extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Parameters")
    private java.util.List<MasterData_FunctionalBlocks_FunctionalBlock_Parameters> Parameters = new java.util.ArrayList<>();

    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public java.util.List<MasterData_FunctionalBlocks_FunctionalBlock_Parameters> getParameters() { return Parameters; }
    public void setParameters(java.util.List<MasterData_FunctionalBlocks_FunctionalBlock_Parameters> value) { this.Parameters = value; }
}