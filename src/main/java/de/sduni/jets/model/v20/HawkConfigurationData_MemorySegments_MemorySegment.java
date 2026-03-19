package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HawkConfigurationData_MemorySegments_MemorySegment extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Length")
    private long Length;
    @JacksonXmlProperty(isAttribute = true, localName = "Optional")
    private boolean Optional;
    @JacksonXmlProperty(isAttribute = true, localName = "MemoryType")
    private String MemoryType;
    @JacksonXmlProperty(localName = "Location")
    private ResourceLocation Location = null;
    @JacksonXmlProperty(localName = "AccessRights")
    private HawkConfigurationData_MemorySegments_MemorySegment_AccessRights AccessRights = null;

    public long getLength() { return Length; }
    public void setLength(long value) { this.Length = value; }
    public boolean getOptional() { return Optional; }
    public void setOptional(boolean value) { this.Optional = value; }
    public String getMemoryType() { return MemoryType; }
    public void setMemoryType(String value) { this.MemoryType = value; }
    public ResourceLocation getLocation() { return Location; }
    public void setLocation(ResourceLocation value) { this.Location = value; }
    public HawkConfigurationData_MemorySegments_MemorySegment_AccessRights getAccessRights() { return AccessRights; }
    public void setAccessRights(HawkConfigurationData_MemorySegments_MemorySegment_AccessRights value) { this.AccessRights = value; }
}