package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LdCtrlAbsSegment extends KnxBase {
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
    @JacksonXmlProperty(isAttribute = true, localName = "SegType")
    private short SegType;
    @JacksonXmlProperty(isAttribute = true, localName = "Address")
    private int Address;
    @JacksonXmlProperty(isAttribute = true, localName = "Size")
    private int Size;
    @JacksonXmlProperty(isAttribute = true, localName = "Access")
    private short Access;
    @JacksonXmlProperty(isAttribute = true, localName = "MemType")
    private short MemType;
    @JacksonXmlProperty(isAttribute = true, localName = "SegFlags")
    private short SegFlags;
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
    public short getSegType() { return SegType; }
    public void setSegType(short value) { this.SegType = value; }
    public int getAddress() { return Address; }
    public void setAddress(int value) { this.Address = value; }
    public int getSize() { return Size; }
    public void setSize(int value) { this.Size = value; }
    public short getAccess() { return Access; }
    public void setAccess(short value) { this.Access = value; }
    public short getMemType() { return MemType; }
    public void setMemType(short value) { this.MemType = value; }
    public short getSegFlags() { return SegFlags; }
    public void setSegFlags(short value) { this.SegFlags = value; }
    public java.util.List<LdCtrlBase_OnError> getOnError() { return OnError; }
    public void setOnError(java.util.List<LdCtrlBase_OnError> value) { this.OnError = value; }
}