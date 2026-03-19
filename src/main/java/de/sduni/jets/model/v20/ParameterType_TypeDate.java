package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterType_TypeDate extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Encoding")
    private String Encoding;
    @JacksonXmlProperty(isAttribute = true, localName = "DisplayTheYear")
    private boolean DisplayTheYear;

    public String getEncoding() { return Encoding; }
    public void setEncoding(String value) { this.Encoding = value; }
    public boolean getDisplayTheYear() { return DisplayTheYear; }
    public void setDisplayTheYear(boolean value) { this.DisplayTheYear = value; }
}