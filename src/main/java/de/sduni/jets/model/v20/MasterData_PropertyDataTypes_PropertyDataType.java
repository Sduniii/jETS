package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData_PropertyDataTypes_PropertyDataType extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Number")
    private long Number;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Size")
    private long Size;
    @JacksonXmlProperty(isAttribute = true, localName = "ReadSize")
    private short ReadSize;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public long getNumber() { return Number; }
    public void setNumber(long value) { this.Number = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public long getSize() { return Size; }
    public void setSize(long value) { this.Size = value; }
    public short getReadSize() { return ReadSize; }
    public void setReadSize(short value) { this.ReadSize = value; }
}