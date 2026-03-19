package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LdCtrlCompareMem extends KnxBase {
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
    @JacksonXmlProperty(isAttribute = true, localName = "AddressSpace")
    private String AddressSpace;
    @JacksonXmlProperty(isAttribute = true, localName = "Address")
    private long Address;
    @JacksonXmlProperty(isAttribute = true, localName = "Size")
    private long Size;
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
    public String getAddressSpace() { return AddressSpace; }
    public void setAddressSpace(String value) { this.AddressSpace = value; }
    public long getAddress() { return Address; }
    public void setAddress(long value) { this.Address = value; }
    public long getSize() { return Size; }
    public void setSize(long value) { this.Size = value; }
    public java.util.List<LdCtrlBase_OnError> getOnError() { return OnError; }
    public void setOnError(java.util.List<LdCtrlBase_OnError> value) { this.OnError = value; }
}