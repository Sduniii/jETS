package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrationInfo extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "RegistrationStatus")
    private String RegistrationStatus;
    @JacksonXmlProperty(isAttribute = true, localName = "RegistrationNumber")
    private String RegistrationNumber;
    @JacksonXmlProperty(isAttribute = true, localName = "OriginalRegistrationNumber")
    private String OriginalRegistrationNumber;
    @JacksonXmlProperty(isAttribute = true, localName = "RegistrationDate")
    private String RegistrationDate;
    @JacksonXmlProperty(isAttribute = true, localName = "RegistrationSignature")
    private byte[] RegistrationSignature;
    @JacksonXmlProperty(isAttribute = true, localName = "RegistrationKey")
    private String RegistrationKey;

    public String getRegistrationStatus() { return RegistrationStatus; }
    public void setRegistrationStatus(String value) { this.RegistrationStatus = value; }
    public String getRegistrationNumber() { return RegistrationNumber; }
    public void setRegistrationNumber(String value) { this.RegistrationNumber = value; }
    public String getOriginalRegistrationNumber() { return OriginalRegistrationNumber; }
    public void setOriginalRegistrationNumber(String value) { this.OriginalRegistrationNumber = value; }
    public String getRegistrationDate() { return RegistrationDate; }
    public void setRegistrationDate(String value) { this.RegistrationDate = value; }
    public byte[] getRegistrationSignature() { return RegistrationSignature; }
    public void setRegistrationSignature(byte[] value) { this.RegistrationSignature = value; }
    public String getRegistrationKey() { return RegistrationKey; }
    public void setRegistrationKey(String value) { this.RegistrationKey = value; }
}