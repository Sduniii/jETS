package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LdCtrlMerge extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "AppliesTo")
    private String AppliesTo;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "MergeId")
    private short MergeId;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "OnError")
    private java.util.List<LdCtrlBase_OnError> OnError = new java.util.ArrayList<>();

    public String getAppliesTo() { return AppliesTo; }
    public void setAppliesTo(String value) { this.AppliesTo = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public short getMergeId() { return MergeId; }
    public void setMergeId(short value) { this.MergeId = value; }
    public java.util.List<LdCtrlBase_OnError> getOnError() { return OnError; }
    public void setOnError(java.util.List<LdCtrlBase_OnError> value) { this.OnError = value; }
}