package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleDefStatic_Parameters_Union_Memory extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "CodeSegment")
    private String CodeSegment;
    @JacksonXmlProperty(isAttribute = true, localName = "Offset")
    private long Offset;
    @JacksonXmlProperty(isAttribute = true, localName = "BitOffset")
    private short BitOffset;
    @JacksonXmlProperty(isAttribute = true, localName = "BaseOffset")
    private String BaseOffset;

    public String getCodeSegment() { return CodeSegment; }
    public void setCodeSegment(String value) { this.CodeSegment = value; }
    public long getOffset() { return Offset; }
    public void setOffset(long value) { this.Offset = value; }
    public short getBitOffset() { return BitOffset; }
    public void setBitOffset(short value) { this.BitOffset = value; }
    public String getBaseOffset() { return BaseOffset; }
    public void setBaseOffset(String value) { this.BaseOffset = value; }
}