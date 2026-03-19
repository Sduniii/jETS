package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MaskVersion extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "MaskVersion")
    private int MaskVersion;
    @JacksonXmlProperty(isAttribute = true, localName = "MgmtDescriptor01")
    private String MgmtDescriptor01;
    @JacksonXmlProperty(isAttribute = true, localName = "ManagementModel")
    private String ManagementModel;
    @JacksonXmlProperty(isAttribute = true, localName = "MediumTypeRefId")
    private String MediumTypeRefId;
    @JacksonXmlProperty(isAttribute = true, localName = "OtherMediumTypeRefId")
    private String OtherMediumTypeRefId;
    @JacksonXmlProperty(localName = "DownwardCompatibleMasks")
    private MaskVersion_DownwardCompatibleMasks DownwardCompatibleMasks = null;
    @JacksonXmlProperty(localName = "MaskEntries")
    private MaskVersion_MaskEntries MaskEntries = null;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "HawkConfigurationData")
    private java.util.List<HawkConfigurationData> HawkConfigurationData = new java.util.ArrayList<>();

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public int getMaskVersion() { return MaskVersion; }
    public void setMaskVersion(int value) { this.MaskVersion = value; }
    public String getMgmtDescriptor01() { return MgmtDescriptor01; }
    public void setMgmtDescriptor01(String value) { this.MgmtDescriptor01 = value; }
    public String getManagementModel() { return ManagementModel; }
    public void setManagementModel(String value) { this.ManagementModel = value; }
    public String getMediumTypeRefId() { return MediumTypeRefId; }
    public void setMediumTypeRefId(String value) { this.MediumTypeRefId = value; }
    public String getOtherMediumTypeRefId() { return OtherMediumTypeRefId; }
    public void setOtherMediumTypeRefId(String value) { this.OtherMediumTypeRefId = value; }
    public MaskVersion_DownwardCompatibleMasks getDownwardCompatibleMasks() { return DownwardCompatibleMasks; }
    public void setDownwardCompatibleMasks(MaskVersion_DownwardCompatibleMasks value) { this.DownwardCompatibleMasks = value; }
    public MaskVersion_MaskEntries getMaskEntries() { return MaskEntries; }
    public void setMaskEntries(MaskVersion_MaskEntries value) { this.MaskEntries = value; }
    public java.util.List<HawkConfigurationData> getHawkConfigurationData() { return HawkConfigurationData; }
    public void setHawkConfigurationData(java.util.List<HawkConfigurationData> value) { this.HawkConfigurationData = value; }
}