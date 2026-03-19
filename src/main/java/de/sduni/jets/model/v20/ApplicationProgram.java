package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgram extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "ApplicationNumber")
    private int ApplicationNumber;
    @JacksonXmlProperty(isAttribute = true, localName = "ApplicationVersion")
    private short ApplicationVersion;
    @JacksonXmlProperty(isAttribute = true, localName = "ProgramType")
    private String ProgramType;
    @JacksonXmlProperty(isAttribute = true, localName = "MaskVersion")
    private String MaskVersion;
    @JacksonXmlProperty(isAttribute = true, localName = "VisibleDescription")
    private String VisibleDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "LoadProcedureStyle")
    private String LoadProcedureStyle;
    @JacksonXmlProperty(isAttribute = true, localName = "PeiType")
    private short PeiType;
    @JacksonXmlProperty(isAttribute = true, localName = "HelpTopic")
    private long HelpTopic;
    @JacksonXmlProperty(isAttribute = true, localName = "HelpFile")
    private String HelpFile;
    @JacksonXmlProperty(isAttribute = true, localName = "ContextHelpFile")
    private String ContextHelpFile;
    @JacksonXmlProperty(isAttribute = true, localName = "IconFile")
    private String IconFile;
    @JacksonXmlProperty(isAttribute = true, localName = "DefaultLanguage")
    private String DefaultLanguage;
    @JacksonXmlProperty(isAttribute = true, localName = "DynamicTableManagement")
    private boolean DynamicTableManagement;
    @JacksonXmlProperty(isAttribute = true, localName = "Linkable")
    private boolean Linkable;
    @JacksonXmlProperty(isAttribute = true, localName = "IsSecureEnabled")
    private boolean IsSecureEnabled;
    @JacksonXmlProperty(isAttribute = true, localName = "MinEtsVersion")
    private String MinEtsVersion;
    @JacksonXmlProperty(isAttribute = true, localName = "OriginalManufacturer")
    private String OriginalManufacturer;
    @JacksonXmlProperty(isAttribute = true, localName = "PreEts4Style")
    private boolean PreEts4Style;
    @JacksonXmlProperty(isAttribute = true, localName = "ConvertedFromPreEts4Data")
    private boolean ConvertedFromPreEts4Data;
    @JacksonXmlProperty(isAttribute = true, localName = "CreatedFromLegacySchemaVersion")
    private boolean CreatedFromLegacySchemaVersion;
    @JacksonXmlProperty(isAttribute = true, localName = "IPConfig")
    private String IPConfig;
    @JacksonXmlProperty(isAttribute = true, localName = "AdditionalAddressesCount")
    private int AdditionalAddressesCount;
    @JacksonXmlProperty(isAttribute = true, localName = "MaxUserEntries")
    private int MaxUserEntries;
    @JacksonXmlProperty(isAttribute = true, localName = "MaxTunnelingUserEntries")
    private int MaxTunnelingUserEntries;
    @JacksonXmlProperty(isAttribute = true, localName = "MaxSecurityIndividualAddressEntries")
    private int MaxSecurityIndividualAddressEntries;
    @JacksonXmlProperty(isAttribute = true, localName = "MaxSecurityGroupKeyTableEntries")
    private int MaxSecurityGroupKeyTableEntries;
    @JacksonXmlProperty(isAttribute = true, localName = "MaxSecurityP2PKeyTableEntries")
    private int MaxSecurityP2PKeyTableEntries;
    @JacksonXmlProperty(isAttribute = true, localName = "MaxSecurityProxyGroupKeyTableEntries")
    private int MaxSecurityProxyGroupKeyTableEntries;
    @JacksonXmlProperty(isAttribute = true, localName = "MaxSecurityProxyIndividualAddressTableEntries")
    private int MaxSecurityProxyIndividualAddressTableEntries;
    @JacksonXmlProperty(isAttribute = true, localName = "NonRegRelevantDataVersion")
    private int NonRegRelevantDataVersion;
    @JacksonXmlProperty(isAttribute = true, localName = "Broken")
    private boolean Broken;
    @JacksonXmlProperty(isAttribute = true, localName = "DownloadInfoIncomplete")
    private boolean DownloadInfoIncomplete;
    @JacksonXmlProperty(isAttribute = true, localName = "ReplacesVersions")
    private String ReplacesVersions;
    @JacksonXmlProperty(isAttribute = true, localName = "Hash")
    private byte[] Hash;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "Semantics")
    private String Semantics;
    @JacksonXmlProperty(localName = "Static")
    private ApplicationProgramStatic Static = null;
    @JacksonXmlProperty(localName = "ModuleDefs")
    private ApplicationProgram_ModuleDefs ModuleDefs = null;
    @JacksonXmlProperty(localName = "Dynamic")
    private ApplicationProgramDynamic Dynamic = null;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public int getApplicationNumber() { return ApplicationNumber; }
    public void setApplicationNumber(int value) { this.ApplicationNumber = value; }
    public short getApplicationVersion() { return ApplicationVersion; }
    public void setApplicationVersion(short value) { this.ApplicationVersion = value; }
    public String getProgramType() { return ProgramType; }
    public void setProgramType(String value) { this.ProgramType = value; }
    public String getMaskVersion() { return MaskVersion; }
    public void setMaskVersion(String value) { this.MaskVersion = value; }
    public String getVisibleDescription() { return VisibleDescription; }
    public void setVisibleDescription(String value) { this.VisibleDescription = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getLoadProcedureStyle() { return LoadProcedureStyle; }
    public void setLoadProcedureStyle(String value) { this.LoadProcedureStyle = value; }
    public short getPeiType() { return PeiType; }
    public void setPeiType(short value) { this.PeiType = value; }
    public long getHelpTopic() { return HelpTopic; }
    public void setHelpTopic(long value) { this.HelpTopic = value; }
    public String getHelpFile() { return HelpFile; }
    public void setHelpFile(String value) { this.HelpFile = value; }
    public String getContextHelpFile() { return ContextHelpFile; }
    public void setContextHelpFile(String value) { this.ContextHelpFile = value; }
    public String getIconFile() { return IconFile; }
    public void setIconFile(String value) { this.IconFile = value; }
    public String getDefaultLanguage() { return DefaultLanguage; }
    public void setDefaultLanguage(String value) { this.DefaultLanguage = value; }
    public boolean getDynamicTableManagement() { return DynamicTableManagement; }
    public void setDynamicTableManagement(boolean value) { this.DynamicTableManagement = value; }
    public boolean getLinkable() { return Linkable; }
    public void setLinkable(boolean value) { this.Linkable = value; }
    public boolean getIsSecureEnabled() { return IsSecureEnabled; }
    public void setIsSecureEnabled(boolean value) { this.IsSecureEnabled = value; }
    public String getMinEtsVersion() { return MinEtsVersion; }
    public void setMinEtsVersion(String value) { this.MinEtsVersion = value; }
    public String getOriginalManufacturer() { return OriginalManufacturer; }
    public void setOriginalManufacturer(String value) { this.OriginalManufacturer = value; }
    public boolean getPreEts4Style() { return PreEts4Style; }
    public void setPreEts4Style(boolean value) { this.PreEts4Style = value; }
    public boolean getConvertedFromPreEts4Data() { return ConvertedFromPreEts4Data; }
    public void setConvertedFromPreEts4Data(boolean value) { this.ConvertedFromPreEts4Data = value; }
    public boolean getCreatedFromLegacySchemaVersion() { return CreatedFromLegacySchemaVersion; }
    public void setCreatedFromLegacySchemaVersion(boolean value) { this.CreatedFromLegacySchemaVersion = value; }
    public String getIPConfig() { return IPConfig; }
    public void setIPConfig(String value) { this.IPConfig = value; }
    public int getAdditionalAddressesCount() { return AdditionalAddressesCount; }
    public void setAdditionalAddressesCount(int value) { this.AdditionalAddressesCount = value; }
    public int getMaxUserEntries() { return MaxUserEntries; }
    public void setMaxUserEntries(int value) { this.MaxUserEntries = value; }
    public int getMaxTunnelingUserEntries() { return MaxTunnelingUserEntries; }
    public void setMaxTunnelingUserEntries(int value) { this.MaxTunnelingUserEntries = value; }
    public int getMaxSecurityIndividualAddressEntries() { return MaxSecurityIndividualAddressEntries; }
    public void setMaxSecurityIndividualAddressEntries(int value) { this.MaxSecurityIndividualAddressEntries = value; }
    public int getMaxSecurityGroupKeyTableEntries() { return MaxSecurityGroupKeyTableEntries; }
    public void setMaxSecurityGroupKeyTableEntries(int value) { this.MaxSecurityGroupKeyTableEntries = value; }
    public int getMaxSecurityP2PKeyTableEntries() { return MaxSecurityP2PKeyTableEntries; }
    public void setMaxSecurityP2PKeyTableEntries(int value) { this.MaxSecurityP2PKeyTableEntries = value; }
    public int getMaxSecurityProxyGroupKeyTableEntries() { return MaxSecurityProxyGroupKeyTableEntries; }
    public void setMaxSecurityProxyGroupKeyTableEntries(int value) { this.MaxSecurityProxyGroupKeyTableEntries = value; }
    public int getMaxSecurityProxyIndividualAddressTableEntries() { return MaxSecurityProxyIndividualAddressTableEntries; }
    public void setMaxSecurityProxyIndividualAddressTableEntries(int value) { this.MaxSecurityProxyIndividualAddressTableEntries = value; }
    public int getNonRegRelevantDataVersion() { return NonRegRelevantDataVersion; }
    public void setNonRegRelevantDataVersion(int value) { this.NonRegRelevantDataVersion = value; }
    public boolean getBroken() { return Broken; }
    public void setBroken(boolean value) { this.Broken = value; }
    public boolean getDownloadInfoIncomplete() { return DownloadInfoIncomplete; }
    public void setDownloadInfoIncomplete(boolean value) { this.DownloadInfoIncomplete = value; }
    public String getReplacesVersions() { return ReplacesVersions; }
    public void setReplacesVersions(String value) { this.ReplacesVersions = value; }
    public byte[] getHash() { return Hash; }
    public void setHash(byte[] value) { this.Hash = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public String getSemantics() { return Semantics; }
    public void setSemantics(String value) { this.Semantics = value; }
    public ApplicationProgramStatic getStatic() { return Static; }
    public void setStatic(ApplicationProgramStatic value) { this.Static = value; }
    public ApplicationProgram_ModuleDefs getModuleDefs() { return ModuleDefs; }
    public void setModuleDefs(ApplicationProgram_ModuleDefs value) { this.ModuleDefs = value; }
    public ApplicationProgramDynamic getDynamic() { return Dynamic; }
    public void setDynamic(ApplicationProgramDynamic value) { this.Dynamic = value; }
}