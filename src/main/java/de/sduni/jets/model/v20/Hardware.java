package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hardware extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "SerialNumber")
    private String SerialNumber;
    @JacksonXmlProperty(isAttribute = true, localName = "VersionNumber")
    private int VersionNumber;
    @JacksonXmlProperty(isAttribute = true, localName = "BusCurrent")
    private float BusCurrent;
    @JacksonXmlProperty(isAttribute = true, localName = "Tp256")
    private boolean Tp256;
    @JacksonXmlProperty(isAttribute = true, localName = "IsAccessory")
    private boolean IsAccessory;
    @JacksonXmlProperty(isAttribute = true, localName = "HasIndividualAddress")
    private boolean HasIndividualAddress;
    @JacksonXmlProperty(isAttribute = true, localName = "HasApplicationProgram")
    private boolean HasApplicationProgram;
    @JacksonXmlProperty(isAttribute = true, localName = "HasApplicationProgram2")
    private boolean HasApplicationProgram2;
    @JacksonXmlProperty(isAttribute = true, localName = "IsPowerSupply")
    private boolean IsPowerSupply;
    @JacksonXmlProperty(isAttribute = true, localName = "IsChoke")
    private boolean IsChoke;
    @JacksonXmlProperty(isAttribute = true, localName = "IsCoupler")
    private boolean IsCoupler;
    @JacksonXmlProperty(isAttribute = true, localName = "IsPowerLineRepeater")
    private boolean IsPowerLineRepeater;
    @JacksonXmlProperty(isAttribute = true, localName = "IsPowerLineSignalFilter")
    private boolean IsPowerLineSignalFilter;
    @JacksonXmlProperty(isAttribute = true, localName = "IsCable")
    private boolean IsCable;
    @JacksonXmlProperty(isAttribute = true, localName = "IsIPEnabled")
    private boolean IsIPEnabled;
    @JacksonXmlProperty(isAttribute = true, localName = "IsRFRetransmitter")
    private boolean IsRFRetransmitter;
    @JacksonXmlProperty(isAttribute = true, localName = "OriginalManufacturer")
    private String OriginalManufacturer;
    @JacksonXmlProperty(isAttribute = true, localName = "RFRxCapabilities")
    private String RFRxCapabilities;
    @JacksonXmlProperty(isAttribute = true, localName = "RFTxCapabilities")
    private String RFTxCapabilities;
    @JacksonXmlProperty(isAttribute = true, localName = "NoDownloadWithoutPlugin")
    private boolean NoDownloadWithoutPlugin;
    @JacksonXmlProperty(isAttribute = true, localName = "NonRegRelevantDataVersion")
    private int NonRegRelevantDataVersion;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlProperty(localName = "Products")
    private Hardware_Products Products = null;
    @JacksonXmlProperty(localName = "Hardware2Programs")
    private Hardware_Hardware2Programs Hardware2Programs = null;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getSerialNumber() { return SerialNumber; }
    public void setSerialNumber(String value) { this.SerialNumber = value; }
    public int getVersionNumber() { return VersionNumber; }
    public void setVersionNumber(int value) { this.VersionNumber = value; }
    public float getBusCurrent() { return BusCurrent; }
    public void setBusCurrent(float value) { this.BusCurrent = value; }
    public boolean getTp256() { return Tp256; }
    public void setTp256(boolean value) { this.Tp256 = value; }
    public boolean getIsAccessory() { return IsAccessory; }
    public void setIsAccessory(boolean value) { this.IsAccessory = value; }
    public boolean getHasIndividualAddress() { return HasIndividualAddress; }
    public void setHasIndividualAddress(boolean value) { this.HasIndividualAddress = value; }
    public boolean getHasApplicationProgram() { return HasApplicationProgram; }
    public void setHasApplicationProgram(boolean value) { this.HasApplicationProgram = value; }
    public boolean getHasApplicationProgram2() { return HasApplicationProgram2; }
    public void setHasApplicationProgram2(boolean value) { this.HasApplicationProgram2 = value; }
    public boolean getIsPowerSupply() { return IsPowerSupply; }
    public void setIsPowerSupply(boolean value) { this.IsPowerSupply = value; }
    public boolean getIsChoke() { return IsChoke; }
    public void setIsChoke(boolean value) { this.IsChoke = value; }
    public boolean getIsCoupler() { return IsCoupler; }
    public void setIsCoupler(boolean value) { this.IsCoupler = value; }
    public boolean getIsPowerLineRepeater() { return IsPowerLineRepeater; }
    public void setIsPowerLineRepeater(boolean value) { this.IsPowerLineRepeater = value; }
    public boolean getIsPowerLineSignalFilter() { return IsPowerLineSignalFilter; }
    public void setIsPowerLineSignalFilter(boolean value) { this.IsPowerLineSignalFilter = value; }
    public boolean getIsCable() { return IsCable; }
    public void setIsCable(boolean value) { this.IsCable = value; }
    public boolean getIsIPEnabled() { return IsIPEnabled; }
    public void setIsIPEnabled(boolean value) { this.IsIPEnabled = value; }
    public boolean getIsRFRetransmitter() { return IsRFRetransmitter; }
    public void setIsRFRetransmitter(boolean value) { this.IsRFRetransmitter = value; }
    public String getOriginalManufacturer() { return OriginalManufacturer; }
    public void setOriginalManufacturer(String value) { this.OriginalManufacturer = value; }
    public String getRFRxCapabilities() { return RFRxCapabilities; }
    public void setRFRxCapabilities(String value) { this.RFRxCapabilities = value; }
    public String getRFTxCapabilities() { return RFTxCapabilities; }
    public void setRFTxCapabilities(String value) { this.RFTxCapabilities = value; }
    public boolean getNoDownloadWithoutPlugin() { return NoDownloadWithoutPlugin; }
    public void setNoDownloadWithoutPlugin(boolean value) { this.NoDownloadWithoutPlugin = value; }
    public int getNonRegRelevantDataVersion() { return NonRegRelevantDataVersion; }
    public void setNonRegRelevantDataVersion(int value) { this.NonRegRelevantDataVersion = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public Hardware_Products getProducts() { return Products; }
    public void setProducts(Hardware_Products value) { this.Products = value; }
    public Hardware_Hardware2Programs getHardware2Programs() { return Hardware2Programs; }
    public void setHardware2Programs(Hardware_Hardware2Programs value) { this.Hardware2Programs = value; }
}