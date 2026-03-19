package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project_ProjectInformation_DeviceCertificates extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "DeviceCertificate")
    private java.util.List<DeviceCertificate> DeviceCertificate = new java.util.ArrayList<>();

    public java.util.List<DeviceCertificate> getDeviceCertificate() { return DeviceCertificate; }
    public void setDeviceCertificate(java.util.List<DeviceCertificate> value) { this.DeviceCertificate = value; }
}