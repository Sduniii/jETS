package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MemoryUnion extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "CodeSegment")
    private String CodeSegment;
    @JacksonXmlProperty(isAttribute = true, localName = "Offset")
    private long Offset;
    @JacksonXmlProperty(isAttribute = true, localName = "BitOffset")
    private short BitOffset;

    public String getCodeSegment() { return CodeSegment; }
    public void setCodeSegment(String value) { this.CodeSegment = value; }
    public long getOffset() { return Offset; }
    public void setOffset(long value) { this.Offset = value; }
    public short getBitOffset() { return BitOffset; }
    public void setBitOffset(short value) { this.BitOffset = value; }
}