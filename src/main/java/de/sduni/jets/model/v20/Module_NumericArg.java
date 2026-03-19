package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Module_NumericArg extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "RefId")
    private String RefId;
    @JacksonXmlProperty(isAttribute = true, localName = "Value")
    private long Value;
    @JacksonXmlProperty(isAttribute = true, localName = "AllocatorRefId")
    private String AllocatorRefId;
    @JacksonXmlProperty(isAttribute = true, localName = "BaseValue")
    private String BaseValue;

    public String getRefId() { return RefId; }
    public void setRefId(String value) { this.RefId = value; }
    public long getValue() { return Value; }
    public void setValue(long value) { this.Value = value; }
    public String getAllocatorRefId() { return AllocatorRefId; }
    public void setAllocatorRefId(String value) { this.AllocatorRefId = value; }
    public String getBaseValue() { return BaseValue; }
    public void setBaseValue(String value) { this.BaseValue = value; }
}