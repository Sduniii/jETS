package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceInstance_AdditionalAddresses extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Address")
    private java.util.List<DeviceInstance_AdditionalAddresses_Address> Address = new java.util.ArrayList<>();

    public java.util.List<DeviceInstance_AdditionalAddresses_Address> getAddress() { return Address; }
    public void setAddress(java.util.List<DeviceInstance_AdditionalAddresses_Address> value) { this.Address = value; }
}