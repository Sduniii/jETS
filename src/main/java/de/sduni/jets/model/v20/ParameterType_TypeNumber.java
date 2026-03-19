package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterType_TypeNumber extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "SizeInBit")
    private long SizeInBit;
    @JacksonXmlProperty(isAttribute = true, localName = "Type")
    private String Type;
    @JacksonXmlProperty(isAttribute = true, localName = "minInclusive")
    private long minInclusive;
    @JacksonXmlProperty(isAttribute = true, localName = "maxInclusive")
    private long maxInclusive;
    @JacksonXmlProperty(isAttribute = true, localName = "Increment")
    private long Increment;
    @JacksonXmlProperty(isAttribute = true, localName = "UIHint")
    private String UIHint;
    @JacksonXmlProperty(isAttribute = true, localName = "DisplayOffset")
    private double DisplayOffset;
    @JacksonXmlProperty(isAttribute = true, localName = "DisplayFactor")
    private double DisplayFactor;

    public long getSizeInBit() { return SizeInBit; }
    public void setSizeInBit(long value) { this.SizeInBit = value; }
    public String getType() { return Type; }
    public void setType(String value) { this.Type = value; }
    public long getminInclusive() { return minInclusive; }
    public void setminInclusive(long value) { this.minInclusive = value; }
    public long getmaxInclusive() { return maxInclusive; }
    public void setmaxInclusive(long value) { this.maxInclusive = value; }
    public long getIncrement() { return Increment; }
    public void setIncrement(long value) { this.Increment = value; }
    public String getUIHint() { return UIHint; }
    public void setUIHint(String value) { this.UIHint = value; }
    public double getDisplayOffset() { return DisplayOffset; }
    public void setDisplayOffset(double value) { this.DisplayOffset = value; }
    public double getDisplayFactor() { return DisplayFactor; }
    public void setDisplayFactor(double value) { this.DisplayFactor = value; }
}