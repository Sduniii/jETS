package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LdCtrlTaskCtrl2 extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "AppliesTo")
    private String AppliesTo;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "LsmIdx")
    private short LsmIdx;
    @JacksonXmlProperty(isAttribute = true, localName = "ObjType")
    private int ObjType;
    @JacksonXmlProperty(isAttribute = true, localName = "Occurrence")
    private int Occurrence;
    @JacksonXmlProperty(isAttribute = true, localName = "Callback")
    private int Callback;
    @JacksonXmlProperty(isAttribute = true, localName = "Address")
    private int Address;
    @JacksonXmlProperty(isAttribute = true, localName = "Seg0")
    private int Seg0;
    @JacksonXmlProperty(isAttribute = true, localName = "Seg1")
    private int Seg1;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "OnError")
    private java.util.List<LdCtrlBase_OnError> OnError = new java.util.ArrayList<>();

    public String getAppliesTo() { return AppliesTo; }
    public void setAppliesTo(String value) { this.AppliesTo = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public short getLsmIdx() { return LsmIdx; }
    public void setLsmIdx(short value) { this.LsmIdx = value; }
    public int getObjType() { return ObjType; }
    public void setObjType(int value) { this.ObjType = value; }
    public int getOccurrence() { return Occurrence; }
    public void setOccurrence(int value) { this.Occurrence = value; }
    public int getCallback() { return Callback; }
    public void setCallback(int value) { this.Callback = value; }
    public int getAddress() { return Address; }
    public void setAddress(int value) { this.Address = value; }
    public int getSeg0() { return Seg0; }
    public void setSeg0(int value) { this.Seg0 = value; }
    public int getSeg1() { return Seg1; }
    public void setSeg1(int value) { this.Seg1 = value; }
    public java.util.List<LdCtrlBase_OnError> getOnError() { return OnError; }
    public void setOnError(java.util.List<LdCtrlBase_OnError> value) { this.OnError = value; }
}