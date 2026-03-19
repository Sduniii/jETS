package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatapointType_DatapointSubtypes_DatapointSubtype_Format_SignedInteger extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Width")
    private long Width;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Unit")
    private String Unit;
    @JacksonXmlProperty(isAttribute = true, localName = "MinInclusive")
    private long MinInclusive;
    @JacksonXmlProperty(isAttribute = true, localName = "MaxInclusive")
    private long MaxInclusive;
    @JacksonXmlProperty(isAttribute = true, localName = "Coefficient")
    private float Coefficient;
    @JacksonXmlProperty(isAttribute = true, localName = "Offset")
    private long Offset;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public long getWidth() { return Width; }
    public void setWidth(long value) { this.Width = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getUnit() { return Unit; }
    public void setUnit(String value) { this.Unit = value; }
    public long getMinInclusive() { return MinInclusive; }
    public void setMinInclusive(long value) { this.MinInclusive = value; }
    public long getMaxInclusive() { return MaxInclusive; }
    public void setMaxInclusive(long value) { this.MaxInclusive = value; }
    public float getCoefficient() { return Coefficient; }
    public void setCoefficient(float value) { this.Coefficient = value; }
    public long getOffset() { return Offset; }
    public void setOffset(long value) { this.Offset = value; }
}