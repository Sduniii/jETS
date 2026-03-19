package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hardware2Program extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "MediumTypes")
    private String MediumTypes;
    @JacksonXmlProperty(isAttribute = true, localName = "Hash")
    private byte[] Hash;
    @JacksonXmlProperty(isAttribute = true, localName = "CheckSums")
    private byte[] CheckSums;
    @JacksonXmlProperty(isAttribute = true, localName = "LoadedImage")
    private byte[] LoadedImage;
    @JacksonXmlProperty(isAttribute = true, localName = "CouplerCapabilities")
    private String CouplerCapabilities;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ApplicationProgramRef")
    private java.util.List<ApplicationProgramRef> ApplicationProgramRef = new java.util.ArrayList<>();
    @JacksonXmlProperty(localName = "RegistrationInfo")
    private RegistrationInfo RegistrationInfo = null;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getMediumTypes() { return MediumTypes; }
    public void setMediumTypes(String value) { this.MediumTypes = value; }
    public byte[] getHash() { return Hash; }
    public void setHash(byte[] value) { this.Hash = value; }
    public byte[] getCheckSums() { return CheckSums; }
    public void setCheckSums(byte[] value) { this.CheckSums = value; }
    public byte[] getLoadedImage() { return LoadedImage; }
    public void setLoadedImage(byte[] value) { this.LoadedImage = value; }
    public String getCouplerCapabilities() { return CouplerCapabilities; }
    public void setCouplerCapabilities(String value) { this.CouplerCapabilities = value; }
    public java.util.List<ApplicationProgramRef> getApplicationProgramRef() { return ApplicationProgramRef; }
    public void setApplicationProgramRef(java.util.List<ApplicationProgramRef> value) { this.ApplicationProgramRef = value; }
    public RegistrationInfo getRegistrationInfo() { return RegistrationInfo; }
    public void setRegistrationInfo(RegistrationInfo value) { this.RegistrationInfo = value; }
}