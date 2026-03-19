package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData_InterfaceObjectProperties_InterfaceObjectProperty extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Number")
    private long Number;
    @JacksonXmlProperty(isAttribute = true, localName = "ObjectType")
    private String ObjectType;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Text")
    private String Text;
    @JacksonXmlProperty(isAttribute = true, localName = "PDT")
    private String PDT;
    @JacksonXmlProperty(isAttribute = true, localName = "DPT")
    private String DPT;
    @JacksonXmlProperty(isAttribute = true, localName = "Array")
    private boolean Array;
    @JacksonXmlProperty(isAttribute = true, localName = "AccessPolicy")
    private String AccessPolicy;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public long getNumber() { return Number; }
    public void setNumber(long value) { this.Number = value; }
    public String getObjectType() { return ObjectType; }
    public void setObjectType(String value) { this.ObjectType = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getText() { return Text; }
    public void setText(String value) { this.Text = value; }
    public String getPDT() { return PDT; }
    public void setPDT(String value) { this.PDT = value; }
    public String getDPT() { return DPT; }
    public void setDPT(String value) { this.DPT = value; }
    public boolean getArray() { return Array; }
    public void setArray(boolean value) { this.Array = value; }
    public String getAccessPolicy() { return AccessPolicy; }
    public void setAccessPolicy(String value) { this.AccessPolicy = value; }
}