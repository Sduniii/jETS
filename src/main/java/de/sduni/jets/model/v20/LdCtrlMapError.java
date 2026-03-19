package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LdCtrlMapError extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "AppliesTo")
    private String AppliesTo;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "LdCtrlFilter")
    private short LdCtrlFilter;
    @JacksonXmlProperty(isAttribute = true, localName = "OriginalError")
    private long OriginalError;
    @JacksonXmlProperty(isAttribute = true, localName = "MappedError")
    private long MappedError;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "OnError")
    private java.util.List<LdCtrlBase_OnError> OnError = new java.util.ArrayList<>();

    public String getAppliesTo() { return AppliesTo; }
    public void setAppliesTo(String value) { this.AppliesTo = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public short getLdCtrlFilter() { return LdCtrlFilter; }
    public void setLdCtrlFilter(short value) { this.LdCtrlFilter = value; }
    public long getOriginalError() { return OriginalError; }
    public void setOriginalError(long value) { this.OriginalError = value; }
    public long getMappedError() { return MappedError; }
    public void setMappedError(long value) { this.MappedError = value; }
    public java.util.List<LdCtrlBase_OnError> getOnError() { return OnError; }
    public void setOnError(java.util.List<LdCtrlBase_OnError> value) { this.OnError = value; }
}