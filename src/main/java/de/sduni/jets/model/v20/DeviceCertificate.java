package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceCertificate extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "SerialNumber")
    private byte[] SerialNumber;
    @JacksonXmlProperty(isAttribute = true, localName = "FDSK")
    private String FDSK;

    public byte[] getSerialNumber() { return SerialNumber; }
    public void setSerialNumber(byte[] value) { this.SerialNumber = value; }
    public String getFDSK() { return FDSK; }
    public void setFDSK(String value) { this.FDSK = value; }
}