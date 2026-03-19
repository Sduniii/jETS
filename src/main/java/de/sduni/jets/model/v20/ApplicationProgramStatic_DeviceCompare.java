package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic_DeviceCompare extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "StandardComTablesExpectable")
    private String StandardComTablesExpectable;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ExcludeMemory")
    private java.util.List<ApplicationProgramStatic_DeviceCompare_ExcludeMemory> ExcludeMemory = new java.util.ArrayList<>();
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ExcludeProperty")
    private java.util.List<ApplicationProgramStatic_DeviceCompare_ExcludeProperty> ExcludeProperty = new java.util.ArrayList<>();

    public String getStandardComTablesExpectable() { return StandardComTablesExpectable; }
    public void setStandardComTablesExpectable(String value) { this.StandardComTablesExpectable = value; }
    public java.util.List<ApplicationProgramStatic_DeviceCompare_ExcludeMemory> getExcludeMemory() { return ExcludeMemory; }
    public void setExcludeMemory(java.util.List<ApplicationProgramStatic_DeviceCompare_ExcludeMemory> value) { this.ExcludeMemory = value; }
    public java.util.List<ApplicationProgramStatic_DeviceCompare_ExcludeProperty> getExcludeProperty() { return ExcludeProperty; }
    public void setExcludeProperty(java.util.List<ApplicationProgramStatic_DeviceCompare_ExcludeProperty> value) { this.ExcludeProperty = value; }
}