package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyParameter extends KnxBase {
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
}