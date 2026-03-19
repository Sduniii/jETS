package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HawkConfigurationData_Resources_Resource_ResourceType extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Length")
    private long Length;
    @JacksonXmlProperty(isAttribute = true, localName = "Flavour")
    private String Flavour;

    public long getLength() { return Length; }
    public void setLength(long value) { this.Length = value; }
    public String getFlavour() { return Flavour; }
    public void setFlavour(String value) { this.Flavour = value; }
}