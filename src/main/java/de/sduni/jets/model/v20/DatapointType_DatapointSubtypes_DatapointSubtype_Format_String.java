package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatapointType_DatapointSubtypes_DatapointSubtype_Format_String extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Width")
    private long Width;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Unit")
    private String Unit;
    @JacksonXmlProperty(isAttribute = true, localName = "Encoding")
    private String Encoding;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public long getWidth() { return Width; }
    public void setWidth(long value) { this.Width = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getUnit() { return Unit; }
    public void setUnit(String value) { this.Unit = value; }
    public String getEncoding() { return Encoding; }
    public void setEncoding(String value) { this.Encoding = value; }
}