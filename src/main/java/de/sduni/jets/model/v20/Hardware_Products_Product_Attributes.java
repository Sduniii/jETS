package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hardware_Products_Product_Attributes extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Attribute")
    private java.util.List<Hardware_Products_Product_Attributes_Attribute> Attribute = new java.util.ArrayList<>();

    public java.util.List<Hardware_Products_Product_Attributes_Attribute> getAttribute() { return Attribute; }
    public void setAttribute(java.util.List<Hardware_Products_Product_Attributes_Attribute> value) { this.Attribute = value; }
}