package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterType_TypeTime extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "SizeInBit")
    private long SizeInBit;
    @JacksonXmlProperty(isAttribute = true, localName = "Unit")
    private String Unit;
    @JacksonXmlProperty(isAttribute = true, localName = "minInclusive")
    private long minInclusive;
    @JacksonXmlProperty(isAttribute = true, localName = "maxInclusive")
    private long maxInclusive;
    @JacksonXmlProperty(isAttribute = true, localName = "UIHint")
    private String UIHint;

    public long getSizeInBit() { return SizeInBit; }
    public void setSizeInBit(long value) { this.SizeInBit = value; }
    public String getUnit() { return Unit; }
    public void setUnit(String value) { this.Unit = value; }
    public long getminInclusive() { return minInclusive; }
    public void setminInclusive(long value) { this.minInclusive = value; }
    public long getmaxInclusive() { return maxInclusive; }
    public void setmaxInclusive(long value) { this.maxInclusive = value; }
    public String getUIHint() { return UIHint; }
    public void setUIHint(String value) { this.UIHint = value; }
}