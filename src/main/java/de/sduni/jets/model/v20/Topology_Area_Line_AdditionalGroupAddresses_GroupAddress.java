package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Topology_Area_Line_AdditionalGroupAddresses_GroupAddress extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Address")
    private int Address;

    public int getAddress() { return Address; }
    public void setAddress(int value) { this.Address = value; }
}