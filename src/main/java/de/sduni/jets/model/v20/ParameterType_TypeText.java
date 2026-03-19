package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterType_TypeText extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "SizeInBit")
    private long SizeInBit;
    @JacksonXmlProperty(isAttribute = true, localName = "Pattern")
    private String Pattern;

    public long getSizeInBit() { return SizeInBit; }
    public void setSizeInBit(long value) { this.SizeInBit = value; }
    public String getPattern() { return Pattern; }
    public void setPattern(String value) { this.Pattern = value; }
}