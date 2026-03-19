package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FunctionType_FunctionPoint extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Text")
    private String Text;
    @JacksonXmlProperty(isAttribute = true, localName = "Role")
    private String Role;
    @JacksonXmlProperty(isAttribute = true, localName = "DatapointType")
    private String DatapointType;
    @JacksonXmlProperty(isAttribute = true, localName = "Characteristics")
    private String Characteristics;
    @JacksonXmlProperty(isAttribute = true, localName = "Semantics")
    private String Semantics;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getText() { return Text; }
    public void setText(String value) { this.Text = value; }
    public String getRole() { return Role; }
    public void setRole(String value) { this.Role = value; }
    public String getDatapointType() { return DatapointType; }
    public void setDatapointType(String value) { this.DatapointType = value; }
    public String getCharacteristics() { return Characteristics; }
    public void setCharacteristics(String value) { this.Characteristics = value; }
    public String getSemantics() { return Semantics; }
    public void setSemantics(String value) { this.Semantics = value; }
}