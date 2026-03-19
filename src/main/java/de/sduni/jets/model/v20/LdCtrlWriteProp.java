package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LdCtrlWriteProp extends KnxBase {
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
    @JacksonXmlProperty(isAttribute = true, localName = "StartElement")
    private int StartElement;
    @JacksonXmlProperty(isAttribute = true, localName = "Count")
    private int Count;
    @JacksonXmlProperty(isAttribute = true, localName = "Verify")
    private boolean Verify;
    @JacksonXmlProperty(isAttribute = true, localName = "InlineData")
    private String InlineData;
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
    public int getStartElement() { return StartElement; }
    public void setStartElement(int value) { this.StartElement = value; }
    public int getCount() { return Count; }
    public void setCount(int value) { this.Count = value; }
    public boolean getVerify() { return Verify; }
    public void setVerify(boolean value) { this.Verify = value; }
    public String getInlineData() { return InlineData; }
    public void setInlineData(String value) { this.InlineData = value; }
    public java.util.List<LdCtrlBase_OnError> getOnError() { return OnError; }
    public void setOnError(java.util.List<LdCtrlBase_OnError> value) { this.OnError = value; }
}