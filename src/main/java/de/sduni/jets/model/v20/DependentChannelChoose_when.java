package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DependentChannelChoose_when extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Test")
    private String Test;
    @JacksonXmlProperty(isAttribute = true, localName = "Default")
    private boolean Default;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;

    public String getTest() { return Test; }
    public void setTest(String value) { this.Test = value; }
    public boolean getDefault() { return Default; }
    public void setDefault(boolean value) { this.Default = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
}