package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleDefLdCtrlCompareProp extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "AppliesTo")
    private String AppliesTo;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "AllowCachedValue")
    private boolean AllowCachedValue;
    @JacksonXmlProperty(isAttribute = true, localName = "InlineData")
    private String InlineData;
    @JacksonXmlProperty(isAttribute = true, localName = "Mask")
    private String Mask;
    @JacksonXmlProperty(isAttribute = true, localName = "Range")
    private String Range;
    @JacksonXmlProperty(isAttribute = true, localName = "Invert")
    private boolean Invert;
    @JacksonXmlProperty(isAttribute = true, localName = "RetryInterval")
    private int RetryInterval;
    @JacksonXmlProperty(isAttribute = true, localName = "TimeOut")
    private int TimeOut;
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
    @JacksonXmlProperty(isAttribute = true, localName = "BaseObjIdx")
    private String BaseObjIdx;
    @JacksonXmlProperty(isAttribute = true, localName = "BaseOccurrence")
    private String BaseOccurrence;
    @JacksonXmlProperty(isAttribute = true, localName = "BaseStartElement")
    private String BaseStartElement;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "OnError")
    private java.util.List<LdCtrlBase_OnError> OnError = new java.util.ArrayList<>();

    public String getAppliesTo() { return AppliesTo; }
    public void setAppliesTo(String value) { this.AppliesTo = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public boolean getAllowCachedValue() { return AllowCachedValue; }
    public void setAllowCachedValue(boolean value) { this.AllowCachedValue = value; }
    public String getInlineData() { return InlineData; }
    public void setInlineData(String value) { this.InlineData = value; }
    public String getMask() { return Mask; }
    public void setMask(String value) { this.Mask = value; }
    public String getRange() { return Range; }
    public void setRange(String value) { this.Range = value; }
    public boolean getInvert() { return Invert; }
    public void setInvert(boolean value) { this.Invert = value; }
    public int getRetryInterval() { return RetryInterval; }
    public void setRetryInterval(int value) { this.RetryInterval = value; }
    public int getTimeOut() { return TimeOut; }
    public void setTimeOut(int value) { this.TimeOut = value; }
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
    public String getBaseObjIdx() { return BaseObjIdx; }
    public void setBaseObjIdx(String value) { this.BaseObjIdx = value; }
    public String getBaseOccurrence() { return BaseOccurrence; }
    public void setBaseOccurrence(String value) { this.BaseOccurrence = value; }
    public String getBaseStartElement() { return BaseStartElement; }
    public void setBaseStartElement(String value) { this.BaseStartElement = value; }
    public java.util.List<LdCtrlBase_OnError> getOnError() { return OnError; }
    public void setOnError(java.util.List<LdCtrlBase_OnError> value) { this.OnError = value; }
}