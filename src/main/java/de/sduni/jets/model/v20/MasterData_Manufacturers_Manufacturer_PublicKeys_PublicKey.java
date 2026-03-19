package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData_Manufacturers_Manufacturer_PublicKeys_PublicKey extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Number")
    private long Number;
    @JacksonXmlProperty(isAttribute = true, localName = "Revoked")
    private boolean Revoked;
    @JacksonXmlProperty(isAttribute = true, localName = "Purpose")
    private String Purpose;
    @JacksonXmlProperty(localName = "RSAKeyValue")
    private MasterData_Manufacturers_Manufacturer_PublicKeys_PublicKey_RSAKeyValue RSAKeyValue = null;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public long getNumber() { return Number; }
    public void setNumber(long value) { this.Number = value; }
    public boolean getRevoked() { return Revoked; }
    public void setRevoked(boolean value) { this.Revoked = value; }
    public String getPurpose() { return Purpose; }
    public void setPurpose(String value) { this.Purpose = value; }
    public MasterData_Manufacturers_Manufacturer_PublicKeys_PublicKey_RSAKeyValue getRSAKeyValue() { return RSAKeyValue; }
    public void setRSAKeyValue(MasterData_Manufacturers_Manufacturer_PublicKeys_PublicKey_RSAKeyValue value) { this.RSAKeyValue = value; }
}