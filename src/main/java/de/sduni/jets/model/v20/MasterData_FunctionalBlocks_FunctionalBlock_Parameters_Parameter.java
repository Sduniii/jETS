package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData_FunctionalBlocks_FunctionalBlock_Parameters_Parameter extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Property")
    private String Property;
    @JacksonXmlProperty(isAttribute = true, localName = "Description")
    private String Description;

    public String getProperty() { return Property; }
    public void setProperty(String value) { this.Property = value; }
    public String getDescription() { return Description; }
    public void setDescription(String value) { this.Description = value; }
}