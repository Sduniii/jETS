package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic_ComObjectTable extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "CodeSegment")
    private String CodeSegment;
    @JacksonXmlProperty(isAttribute = true, localName = "Offset")
    private long Offset;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ComObject")
    private java.util.List<ComObject> ComObject = new java.util.ArrayList<>();

    public String getCodeSegment() { return CodeSegment; }
    public void setCodeSegment(String value) { this.CodeSegment = value; }
    public long getOffset() { return Offset; }
    public void setOffset(long value) { this.Offset = value; }
    public java.util.List<ComObject> getComObject() { return ComObject; }
    public void setComObject(java.util.List<ComObject> value) { this.ComObject = value; }
}