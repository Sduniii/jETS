package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic_AssociationTable extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "CodeSegment")
    private String CodeSegment;
    @JacksonXmlProperty(isAttribute = true, localName = "Offset")
    private long Offset;
    @JacksonXmlProperty(isAttribute = true, localName = "MaxEntries")
    private long MaxEntries;

    public String getCodeSegment() { return CodeSegment; }
    public void setCodeSegment(String value) { this.CodeSegment = value; }
    public long getOffset() { return Offset; }
    public void setOffset(long value) { this.Offset = value; }
    public long getMaxEntries() { return MaxEntries; }
    public void setMaxEntries(long value) { this.MaxEntries = value; }
}