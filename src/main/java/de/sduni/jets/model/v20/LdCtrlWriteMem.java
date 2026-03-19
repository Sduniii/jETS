package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LdCtrlWriteMem extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "AppliesTo")
    private String AppliesTo;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "AddressSpace")
    private String AddressSpace;
    @JacksonXmlProperty(isAttribute = true, localName = "Address")
    private long Address;
    @JacksonXmlProperty(isAttribute = true, localName = "Size")
    private long Size;
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
    public String getAddressSpace() { return AddressSpace; }
    public void setAddressSpace(String value) { this.AddressSpace = value; }
    public long getAddress() { return Address; }
    public void setAddress(long value) { this.Address = value; }
    public long getSize() { return Size; }
    public void setSize(long value) { this.Size = value; }
    public boolean getVerify() { return Verify; }
    public void setVerify(boolean value) { this.Verify = value; }
    public String getInlineData() { return InlineData; }
    public void setInlineData(String value) { this.InlineData = value; }
    public java.util.List<LdCtrlBase_OnError> getOnError() { return OnError; }
    public void setOnError(java.util.List<LdCtrlBase_OnError> value) { this.OnError = value; }
}