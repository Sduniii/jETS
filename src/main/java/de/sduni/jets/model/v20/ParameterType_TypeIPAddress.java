package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterType_TypeIPAddress extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "AddressType")
    private String AddressType;
    @JacksonXmlProperty(isAttribute = true, localName = "Version")
    private String Version;

    public String getAddressType() { return AddressType; }
    public void setAddressType(String value) { this.AddressType = value; }
    public String getVersion() { return Version; }
    public void setVersion(String value) { this.Version = value; }
}