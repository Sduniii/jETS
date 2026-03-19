package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleDef extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlProperty(localName = "Arguments")
    private ModuleDef_Arguments Arguments = null;
    @JacksonXmlProperty(localName = "Static")
    private ModuleDefStatic Static = null;
    @JacksonXmlProperty(localName = "SubModuleDefs")
    private ModuleDef_SubModuleDefs SubModuleDefs = null;
    @JacksonXmlProperty(localName = "Dynamic")
    private ModuleDefDynamic Dynamic = null;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public ModuleDef_Arguments getArguments() { return Arguments; }
    public void setArguments(ModuleDef_Arguments value) { this.Arguments = value; }
    public ModuleDefStatic getStatic() { return Static; }
    public void setStatic(ModuleDefStatic value) { this.Static = value; }
    public ModuleDef_SubModuleDefs getSubModuleDefs() { return SubModuleDefs; }
    public void setSubModuleDefs(ModuleDef_SubModuleDefs value) { this.SubModuleDefs = value; }
    public ModuleDefDynamic getDynamic() { return Dynamic; }
    public void setDynamic(ModuleDefDynamic value) { this.Dynamic = value; }
}