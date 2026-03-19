package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterType_TypeRestriction extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Base_")
    private String Base_;
    @JacksonXmlProperty(isAttribute = true, localName = "SizeInBit")
    private long SizeInBit;
    @JacksonXmlProperty(isAttribute = true, localName = "UIHint")
    private String UIHint;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Enumeration")
    private java.util.List<ParameterType_TypeRestriction_Enumeration> Enumeration = new java.util.ArrayList<>();

    public String getBase_() { return Base_; }
    public void setBase_(String value) { this.Base_ = value; }
    public long getSizeInBit() { return SizeInBit; }
    public void setSizeInBit(long value) { this.SizeInBit = value; }
    public String getUIHint() { return UIHint; }
    public void setUIHint(String value) { this.UIHint = value; }
    public java.util.List<ParameterType_TypeRestriction_Enumeration> getEnumeration() { return Enumeration; }
    public void setEnumeration(java.util.List<ParameterType_TypeRestriction_Enumeration> value) { this.Enumeration = value; }
}