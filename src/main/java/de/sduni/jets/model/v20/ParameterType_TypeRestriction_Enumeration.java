package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterType_TypeRestriction_Enumeration extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Text")
    private String Text;
    @JacksonXmlProperty(isAttribute = true, localName = "Icon")
    private String Icon;
    @JacksonXmlProperty(isAttribute = true, localName = "PictureAlignment")
    private String PictureAlignment;
    @JacksonXmlProperty(isAttribute = true, localName = "Value")
    private long Value;
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "DisplayOrder")
    private int DisplayOrder;
    @JacksonXmlProperty(isAttribute = true, localName = "BinaryValue")
    private byte[] BinaryValue;

    public String getText() { return Text; }
    public void setText(String value) { this.Text = value; }
    public String getIcon() { return Icon; }
    public void setIcon(String value) { this.Icon = value; }
    public String getPictureAlignment() { return PictureAlignment; }
    public void setPictureAlignment(String value) { this.PictureAlignment = value; }
    public long getValue() { return Value; }
    public void setValue(long value) { this.Value = value; }
    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public int getDisplayOrder() { return DisplayOrder; }
    public void setDisplayOrder(int value) { this.DisplayOrder = value; }
    public byte[] getBinaryValue() { return BinaryValue; }
    public void setBinaryValue(byte[] value) { this.BinaryValue = value; }
}