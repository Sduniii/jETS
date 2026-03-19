package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LdCtrlDeclarePropDesc extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "AppliesTo")
    private String AppliesTo;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "ObjIdx")
    private short ObjIdx;
    @JacksonXmlProperty(isAttribute = true, localName = "ObjType")
    private int ObjType;
    @JacksonXmlProperty(isAttribute = true, localName = "Occurrence")
    private int Occurrence;
    @JacksonXmlProperty(isAttribute = true, localName = "PropId")
    private int PropId;
    @JacksonXmlProperty(isAttribute = true, localName = "PropType")
    private String PropType;
    @JacksonXmlProperty(isAttribute = true, localName = "MaxElements")
    private int MaxElements;
    @JacksonXmlProperty(isAttribute = true, localName = "ReadAccess")
    private short ReadAccess;
    @JacksonXmlProperty(isAttribute = true, localName = "WriteAccess")
    private short WriteAccess;
    @JacksonXmlProperty(isAttribute = true, localName = "Writable")
    private boolean Writable;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "OnError")
    private java.util.List<LdCtrlBase_OnError> OnError = new java.util.ArrayList<>();

    public String getAppliesTo() { return AppliesTo; }
    public void setAppliesTo(String value) { this.AppliesTo = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public short getObjIdx() { return ObjIdx; }
    public void setObjIdx(short value) { this.ObjIdx = value; }
    public int getObjType() { return ObjType; }
    public void setObjType(int value) { this.ObjType = value; }
    public int getOccurrence() { return Occurrence; }
    public void setOccurrence(int value) { this.Occurrence = value; }
    public int getPropId() { return PropId; }
    public void setPropId(int value) { this.PropId = value; }
    public String getPropType() { return PropType; }
    public void setPropType(String value) { this.PropType = value; }
    public int getMaxElements() { return MaxElements; }
    public void setMaxElements(int value) { this.MaxElements = value; }
    public short getReadAccess() { return ReadAccess; }
    public void setReadAccess(short value) { this.ReadAccess = value; }
    public short getWriteAccess() { return WriteAccess; }
    public void setWriteAccess(short value) { this.WriteAccess = value; }
    public boolean getWritable() { return Writable; }
    public void setWritable(boolean value) { this.Writable = value; }
    public java.util.List<LdCtrlBase_OnError> getOnError() { return OnError; }
    public void setOnError(java.util.List<LdCtrlBase_OnError> value) { this.OnError = value; }
}