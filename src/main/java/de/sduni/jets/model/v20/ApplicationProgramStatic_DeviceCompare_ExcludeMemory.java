package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic_DeviceCompare_ExcludeMemory extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "CodeSegment")
    private String CodeSegment;
    @JacksonXmlProperty(isAttribute = true, localName = "Offset")
    private long Offset;
    @JacksonXmlProperty(isAttribute = true, localName = "Size")
    private long Size;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;

    public String getCodeSegment() { return CodeSegment; }
    public void setCodeSegment(String value) { this.CodeSegment = value; }
    public long getOffset() { return Offset; }
    public void setOffset(long value) { this.Offset = value; }
    public long getSize() { return Size; }
    public void setSize(long value) { this.Size = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
}