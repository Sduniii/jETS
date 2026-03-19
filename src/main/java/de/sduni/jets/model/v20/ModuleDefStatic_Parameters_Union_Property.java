package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleDefStatic_Parameters_Union_Property extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "ObjectIndex")
    private short ObjectIndex;
    @JacksonXmlProperty(isAttribute = true, localName = "ObjectType")
    private int ObjectType;
    @JacksonXmlProperty(isAttribute = true, localName = "Occurrence")
    private int Occurrence;
    @JacksonXmlProperty(isAttribute = true, localName = "PropertyId")
    private int PropertyId;
    @JacksonXmlProperty(isAttribute = true, localName = "Offset")
    private long Offset;
    @JacksonXmlProperty(isAttribute = true, localName = "BitOffset")
    private short BitOffset;
    @JacksonXmlProperty(isAttribute = true, localName = "BaseOffset")
    private String BaseOffset;
    @JacksonXmlProperty(isAttribute = true, localName = "BaseIndex")
    private String BaseIndex;
    @JacksonXmlProperty(isAttribute = true, localName = "BaseOccurrence")
    private String BaseOccurrence;

    public short getObjectIndex() { return ObjectIndex; }
    public void setObjectIndex(short value) { this.ObjectIndex = value; }
    public int getObjectType() { return ObjectType; }
    public void setObjectType(int value) { this.ObjectType = value; }
    public int getOccurrence() { return Occurrence; }
    public void setOccurrence(int value) { this.Occurrence = value; }
    public int getPropertyId() { return PropertyId; }
    public void setPropertyId(int value) { this.PropertyId = value; }
    public long getOffset() { return Offset; }
    public void setOffset(long value) { this.Offset = value; }
    public short getBitOffset() { return BitOffset; }
    public void setBitOffset(short value) { this.BitOffset = value; }
    public String getBaseOffset() { return BaseOffset; }
    public void setBaseOffset(String value) { this.BaseOffset = value; }
    public String getBaseIndex() { return BaseIndex; }
    public void setBaseIndex(String value) { this.BaseIndex = value; }
    public String getBaseOccurrence() { return BaseOccurrence; }
    public void setBaseOccurrence(String value) { this.BaseOccurrence = value; }
}