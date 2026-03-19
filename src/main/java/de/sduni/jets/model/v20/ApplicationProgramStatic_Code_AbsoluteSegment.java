package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic_Code_AbsoluteSegment extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Size")
    private long Size;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "MemoryType")
    private String MemoryType;
    @JacksonXmlProperty(isAttribute = true, localName = "Address")
    private long Address;
    @JacksonXmlProperty(isAttribute = true, localName = "UserMemory")
    private boolean UserMemory;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public long getSize() { return Size; }
    public void setSize(long value) { this.Size = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public String getMemoryType() { return MemoryType; }
    public void setMemoryType(String value) { this.MemoryType = value; }
    public long getAddress() { return Address; }
    public void setAddress(long value) { this.Address = value; }
    public boolean getUserMemory() { return UserMemory; }
    public void setUserMemory(boolean value) { this.UserMemory = value; }
}