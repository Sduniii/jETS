package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HawkConfigurationData_Features_Feature extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Value")
    private int Value;

    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public int getValue() { return Value; }
    public void setValue(int value) { this.Value = value; }
}