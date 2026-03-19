package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatapointType_DatapointSubtypes_DatapointSubtype_Format_Enumeration_EnumValue extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Value")
    private int Value;
    @JacksonXmlProperty(isAttribute = true, localName = "Text")
    private String Text;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public int getValue() { return Value; }
    public void setValue(int value) { this.Value = value; }
    public String getText() { return Text; }
    public void setText(String value) { this.Text = value; }
}