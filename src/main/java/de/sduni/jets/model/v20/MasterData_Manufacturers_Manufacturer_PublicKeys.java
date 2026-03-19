package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData_Manufacturers_Manufacturer_PublicKeys extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "PublicKey")
    private java.util.List<MasterData_Manufacturers_Manufacturer_PublicKeys_PublicKey> PublicKey = new java.util.ArrayList<>();

    public java.util.List<MasterData_Manufacturers_Manufacturer_PublicKeys_PublicKey> getPublicKey() { return PublicKey; }
    public void setPublicKey(java.util.List<MasterData_Manufacturers_Manufacturer_PublicKeys_PublicKey> value) { this.PublicKey = value; }
}