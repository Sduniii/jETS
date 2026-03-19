package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceInstance extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "ProductRefId")
    private String ProductRefId;
    @JacksonXmlProperty(isAttribute = true, localName = "Hardware2ProgramRefId")
    private String Hardware2ProgramRefId;
    @JacksonXmlProperty(isAttribute = true, localName = "Address")
    private int Address;
    @JacksonXmlProperty(isAttribute = true, localName = "Comment")
    private String Comment;
    @JacksonXmlProperty(isAttribute = true, localName = "LastModified")
    private java.time.LocalDateTime LastModified;
    @JacksonXmlProperty(isAttribute = true, localName = "LastDownload")
    private java.time.LocalDateTime LastDownload;
    @JacksonXmlProperty(isAttribute = true, localName = "LastUsedAPDULength")
    private int LastUsedAPDULength;
    @JacksonXmlProperty(isAttribute = true, localName = "ReadMaxAPDULength")
    private int ReadMaxAPDULength;
    @JacksonXmlProperty(isAttribute = true, localName = "ReadMaxRoutingAPDULength")
    private int ReadMaxRoutingAPDULength;
    @JacksonXmlProperty(isAttribute = true, localName = "InstallationHints")
    private String InstallationHints;
    @JacksonXmlProperty(isAttribute = true, localName = "CompletionStatus")
    private String CompletionStatus;
    @JacksonXmlProperty(isAttribute = true, localName = "IndividualAddressLoaded")
    private boolean IndividualAddressLoaded;
    @JacksonXmlProperty(isAttribute = true, localName = "ApplicationProgramLoaded")
    private boolean ApplicationProgramLoaded;
    @JacksonXmlProperty(isAttribute = true, localName = "ParametersLoaded")
    private boolean ParametersLoaded;
    @JacksonXmlProperty(isAttribute = true, localName = "CommunicationPartLoaded")
    private boolean CommunicationPartLoaded;
    @JacksonXmlProperty(isAttribute = true, localName = "MediumConfigLoaded")
    private boolean MediumConfigLoaded;
    @JacksonXmlProperty(isAttribute = true, localName = "LoadedImage")
    private byte[] LoadedImage;
    @JacksonXmlProperty(isAttribute = true, localName = "Description")
    private String Description;
    @JacksonXmlProperty(isAttribute = true, localName = "CheckSums")
    private byte[] CheckSums;
    @JacksonXmlProperty(isAttribute = true, localName = "DownloadCounter")
    private long DownloadCounter;
    @JacksonXmlProperty(isAttribute = true, localName = "IsActivityCalculated")
    private boolean IsActivityCalculated;
    @JacksonXmlProperty(isAttribute = true, localName = "Broken")
    private boolean Broken;
    @JacksonXmlProperty(isAttribute = true, localName = "SerialNumber")
    private byte[] SerialNumber;
    @JacksonXmlProperty(isAttribute = true, localName = "UniqueId")
    private String UniqueId;
    @JacksonXmlProperty(isAttribute = true, localName = "IsRFRetransmitter")
    private boolean IsRFRetransmitter;
    @JacksonXmlProperty(isAttribute = true, localName = "Puid")
    private int Puid;
    @JacksonXmlProperty(isAttribute = true, localName = "Context")
    private String Context;
    @JacksonXmlProperty(localName = "ParameterInstanceRefs")
    private DeviceInstance_ParameterInstanceRefs ParameterInstanceRefs = null;
    @JacksonXmlProperty(localName = "ComObjectInstanceRefs")
    private DeviceInstance_ComObjectInstanceRefs ComObjectInstanceRefs = null;
    @JacksonXmlProperty(localName = "ChannelInstances")
    private DeviceInstance_ChannelInstances ChannelInstances = null;
    @JacksonXmlProperty(localName = "ModuleInstances")
    private DeviceInstance_ModuleInstances ModuleInstances = null;
    @JacksonXmlProperty(localName = "GroupObjectTree")
    private DeviceInstance_GroupObjectTree GroupObjectTree = null;
    @JacksonXmlProperty(localName = "AdditionalAddresses")
    private DeviceInstance_AdditionalAddresses AdditionalAddresses = null;
    @JacksonXmlProperty(localName = "BinaryData")
    private DeviceInstance_BinaryData BinaryData = null;
    @JacksonXmlProperty(localName = "IPConfig")
    private IPConfig IPConfig = null;
    @JacksonXmlProperty(localName = "Security")
    private Security Security = null;
    @JacksonXmlProperty(localName = "BusInterfaces")
    private DeviceInstance_BusInterfaces BusInterfaces = null;
    @JacksonXmlProperty(localName = "RfFastAckSlots")
    private DeviceInstance_RfFastAckSlots RfFastAckSlots = null;

    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getProductRefId() { return ProductRefId; }
    public void setProductRefId(String value) { this.ProductRefId = value; }
    public String getHardware2ProgramRefId() { return Hardware2ProgramRefId; }
    public void setHardware2ProgramRefId(String value) { this.Hardware2ProgramRefId = value; }
    public int getAddress() { return Address; }
    public void setAddress(int value) { this.Address = value; }
    public String getComment() { return Comment; }
    public void setComment(String value) { this.Comment = value; }
    public java.time.LocalDateTime getLastModified() { return LastModified; }
    public void setLastModified(java.time.LocalDateTime value) { this.LastModified = value; }
    public java.time.LocalDateTime getLastDownload() { return LastDownload; }
    public void setLastDownload(java.time.LocalDateTime value) { this.LastDownload = value; }
    public int getLastUsedAPDULength() { return LastUsedAPDULength; }
    public void setLastUsedAPDULength(int value) { this.LastUsedAPDULength = value; }
    public int getReadMaxAPDULength() { return ReadMaxAPDULength; }
    public void setReadMaxAPDULength(int value) { this.ReadMaxAPDULength = value; }
    public int getReadMaxRoutingAPDULength() { return ReadMaxRoutingAPDULength; }
    public void setReadMaxRoutingAPDULength(int value) { this.ReadMaxRoutingAPDULength = value; }
    public String getInstallationHints() { return InstallationHints; }
    public void setInstallationHints(String value) { this.InstallationHints = value; }
    public String getCompletionStatus() { return CompletionStatus; }
    public void setCompletionStatus(String value) { this.CompletionStatus = value; }
    public boolean getIndividualAddressLoaded() { return IndividualAddressLoaded; }
    public void setIndividualAddressLoaded(boolean value) { this.IndividualAddressLoaded = value; }
    public boolean getApplicationProgramLoaded() { return ApplicationProgramLoaded; }
    public void setApplicationProgramLoaded(boolean value) { this.ApplicationProgramLoaded = value; }
    public boolean getParametersLoaded() { return ParametersLoaded; }
    public void setParametersLoaded(boolean value) { this.ParametersLoaded = value; }
    public boolean getCommunicationPartLoaded() { return CommunicationPartLoaded; }
    public void setCommunicationPartLoaded(boolean value) { this.CommunicationPartLoaded = value; }
    public boolean getMediumConfigLoaded() { return MediumConfigLoaded; }
    public void setMediumConfigLoaded(boolean value) { this.MediumConfigLoaded = value; }
    public byte[] getLoadedImage() { return LoadedImage; }
    public void setLoadedImage(byte[] value) { this.LoadedImage = value; }
    public String getDescription() { return Description; }
    public void setDescription(String value) { this.Description = value; }
    public byte[] getCheckSums() { return CheckSums; }
    public void setCheckSums(byte[] value) { this.CheckSums = value; }
    public long getDownloadCounter() { return DownloadCounter; }
    public void setDownloadCounter(long value) { this.DownloadCounter = value; }
    public boolean getIsActivityCalculated() { return IsActivityCalculated; }
    public void setIsActivityCalculated(boolean value) { this.IsActivityCalculated = value; }
    public boolean getBroken() { return Broken; }
    public void setBroken(boolean value) { this.Broken = value; }
    public byte[] getSerialNumber() { return SerialNumber; }
    public void setSerialNumber(byte[] value) { this.SerialNumber = value; }
    public String getUniqueId() { return UniqueId; }
    public void setUniqueId(String value) { this.UniqueId = value; }
    public boolean getIsRFRetransmitter() { return IsRFRetransmitter; }
    public void setIsRFRetransmitter(boolean value) { this.IsRFRetransmitter = value; }
    public int getPuid() { return Puid; }
    public void setPuid(int value) { this.Puid = value; }
    public String getContext() { return Context; }
    public void setContext(String value) { this.Context = value; }
    public DeviceInstance_ParameterInstanceRefs getParameterInstanceRefs() { return ParameterInstanceRefs; }
    public void setParameterInstanceRefs(DeviceInstance_ParameterInstanceRefs value) { this.ParameterInstanceRefs = value; }
    public DeviceInstance_ComObjectInstanceRefs getComObjectInstanceRefs() { return ComObjectInstanceRefs; }
    public void setComObjectInstanceRefs(DeviceInstance_ComObjectInstanceRefs value) { this.ComObjectInstanceRefs = value; }
    public DeviceInstance_ChannelInstances getChannelInstances() { return ChannelInstances; }
    public void setChannelInstances(DeviceInstance_ChannelInstances value) { this.ChannelInstances = value; }
    public DeviceInstance_ModuleInstances getModuleInstances() { return ModuleInstances; }
    public void setModuleInstances(DeviceInstance_ModuleInstances value) { this.ModuleInstances = value; }
    public DeviceInstance_GroupObjectTree getGroupObjectTree() { return GroupObjectTree; }
    public void setGroupObjectTree(DeviceInstance_GroupObjectTree value) { this.GroupObjectTree = value; }
    public DeviceInstance_AdditionalAddresses getAdditionalAddresses() { return AdditionalAddresses; }
    public void setAdditionalAddresses(DeviceInstance_AdditionalAddresses value) { this.AdditionalAddresses = value; }
    public DeviceInstance_BinaryData getBinaryData() { return BinaryData; }
    public void setBinaryData(DeviceInstance_BinaryData value) { this.BinaryData = value; }
    public IPConfig getIPConfig() { return IPConfig; }
    public void setIPConfig(IPConfig value) { this.IPConfig = value; }
    public Security getSecurity() { return Security; }
    public void setSecurity(Security value) { this.Security = value; }
    public DeviceInstance_BusInterfaces getBusInterfaces() { return BusInterfaces; }
    public void setBusInterfaces(DeviceInstance_BusInterfaces value) { this.BusInterfaces = value; }
    public DeviceInstance_RfFastAckSlots getRfFastAckSlots() { return RfFastAckSlots; }
    public void setRfFastAckSlots(DeviceInstance_RfFastAckSlots value) { this.RfFastAckSlots = value; }
}