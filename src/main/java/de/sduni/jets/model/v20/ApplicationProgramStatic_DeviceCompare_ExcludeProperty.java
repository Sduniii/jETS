package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic_DeviceCompare_ExcludeProperty extends KnxBase {
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
    @JacksonXmlProperty(isAttribute = true, localName = "Size")
    private long Size;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;

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
    public long getSize() { return Size; }
    public void setSize(long value) { this.Size = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
}