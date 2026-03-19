package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hardware_Products_Product_Baggages extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Baggage")
    private java.util.List<Hardware_Products_Product_Baggages_Baggage> Baggage = new java.util.ArrayList<>();

    public java.util.List<Hardware_Products_Product_Baggages_Baggage> getBaggage() { return Baggage; }
    public void setBaggage(java.util.List<Hardware_Products_Product_Baggages_Baggage> value) { this.Baggage = value; }
}