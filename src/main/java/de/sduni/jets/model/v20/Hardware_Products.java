package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hardware_Products extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Product")
    private java.util.List<Hardware_Products_Product> Product = new java.util.ArrayList<>();

    public java.util.List<Hardware_Products_Product> getProduct() { return Product; }
    public void setProduct(java.util.List<Hardware_Products_Product> value) { this.Product = value; }
}