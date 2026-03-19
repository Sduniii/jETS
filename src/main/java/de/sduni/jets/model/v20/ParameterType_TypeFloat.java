package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterType_TypeFloat extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Encoding")
    private String Encoding;
    @JacksonXmlProperty(isAttribute = true, localName = "minInclusive")
    private double minInclusive;
    @JacksonXmlProperty(isAttribute = true, localName = "maxInclusive")
    private double maxInclusive;
    @JacksonXmlProperty(isAttribute = true, localName = "Increment")
    private double Increment;
    @JacksonXmlProperty(isAttribute = true, localName = "UIHint")
    private String UIHint;
    @JacksonXmlProperty(isAttribute = true, localName = "DisplayFormat")
    private String DisplayFormat;
    @JacksonXmlProperty(isAttribute = true, localName = "DisplayOffset")
    private double DisplayOffset;
    @JacksonXmlProperty(isAttribute = true, localName = "DisplayFactor")
    private double DisplayFactor;

    public String getEncoding() { return Encoding; }
    public void setEncoding(String value) { this.Encoding = value; }
    public double getminInclusive() { return minInclusive; }
    public void setminInclusive(double value) { this.minInclusive = value; }
    public double getmaxInclusive() { return maxInclusive; }
    public void setmaxInclusive(double value) { this.maxInclusive = value; }
    public double getIncrement() { return Increment; }
    public void setIncrement(double value) { this.Increment = value; }
    public String getUIHint() { return UIHint; }
    public void setUIHint(String value) { this.UIHint = value; }
    public String getDisplayFormat() { return DisplayFormat; }
    public void setDisplayFormat(String value) { this.DisplayFormat = value; }
    public double getDisplayOffset() { return DisplayOffset; }
    public void setDisplayOffset(double value) { this.DisplayOffset = value; }
    public double getDisplayFactor() { return DisplayFactor; }
    public void setDisplayFactor(double value) { this.DisplayFactor = value; }
}