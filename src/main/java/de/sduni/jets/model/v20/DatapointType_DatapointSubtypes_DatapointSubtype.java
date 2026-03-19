package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatapointType_DatapointSubtypes_DatapointSubtype extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Number")
    private long Number;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Text")
    private String Text;
    @JacksonXmlProperty(isAttribute = true, localName = "Default")
    private boolean Default;
    @JacksonXmlProperty(isAttribute = true, localName = "PDT")
    private String PDT;
    @JacksonXmlProperty(localName = "Format")
    private DatapointType_DatapointSubtypes_DatapointSubtype_Format Format = null;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public long getNumber() { return Number; }
    public void setNumber(long value) { this.Number = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getText() { return Text; }
    public void setText(String value) { this.Text = value; }
    public boolean getDefault() { return Default; }
    public void setDefault(boolean value) { this.Default = value; }
    public String getPDT() { return PDT; }
    public void setPDT(String value) { this.PDT = value; }
    public DatapointType_DatapointSubtypes_DatapointSubtype_Format getFormat() { return Format; }
    public void setFormat(DatapointType_DatapointSubtypes_DatapointSubtype_Format value) { this.Format = value; }
}