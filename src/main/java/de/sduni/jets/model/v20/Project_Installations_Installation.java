package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project_Installations_Installation extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "InstallationId")
    private int InstallationId;
    @JacksonXmlProperty(isAttribute = true, localName = "BCUKey")
    private long BCUKey;
    @JacksonXmlProperty(isAttribute = true, localName = "IPRoutingMulticastAddress")
    private String IPRoutingMulticastAddress;
    @JacksonXmlProperty(isAttribute = true, localName = "MulticastTTL")
    private short MulticastTTL;
    @JacksonXmlProperty(isAttribute = true, localName = "IPRoutingBackboneKey")
    private String IPRoutingBackboneKey;
    @JacksonXmlProperty(isAttribute = true, localName = "IPRoutingLatencyTolerance")
    private int IPRoutingLatencyTolerance;
    @JacksonXmlProperty(isAttribute = true, localName = "IPSyncLatencyFraction")
    private float IPSyncLatencyFraction;
    @JacksonXmlProperty(isAttribute = true, localName = "DefaultLine")
    private String DefaultLine;
    @JacksonXmlProperty(isAttribute = true, localName = "CompletionStatus")
    private String CompletionStatus;
    @JacksonXmlProperty(isAttribute = true, localName = "IPRoutingBackboneSecurity")
    private String IPRoutingBackboneSecurity;
    @JacksonXmlProperty(isAttribute = true, localName = "SplitType")
    private String SplitType;
    @JacksonXmlProperty(localName = "Topology")
    private Topology Topology = null;
    @JacksonXmlProperty(localName = "Locations")
    private Locations Locations = null;
    @JacksonXmlProperty(localName = "GroupAddresses")
    private GroupAddresses GroupAddresses = null;
    @JacksonXmlProperty(localName = "P2PLinks")
    private P2PLinks P2PLinks = null;
    @JacksonXmlProperty(localName = "Trades")
    private Trades Trades = null;
    @JacksonXmlProperty(localName = "SplitInfos")
    private SplitInfos SplitInfos = null;

    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public int getInstallationId() { return InstallationId; }
    public void setInstallationId(int value) { this.InstallationId = value; }
    public long getBCUKey() { return BCUKey; }
    public void setBCUKey(long value) { this.BCUKey = value; }
    public String getIPRoutingMulticastAddress() { return IPRoutingMulticastAddress; }
    public void setIPRoutingMulticastAddress(String value) { this.IPRoutingMulticastAddress = value; }
    public short getMulticastTTL() { return MulticastTTL; }
    public void setMulticastTTL(short value) { this.MulticastTTL = value; }
    public String getIPRoutingBackboneKey() { return IPRoutingBackboneKey; }
    public void setIPRoutingBackboneKey(String value) { this.IPRoutingBackboneKey = value; }
    public int getIPRoutingLatencyTolerance() { return IPRoutingLatencyTolerance; }
    public void setIPRoutingLatencyTolerance(int value) { this.IPRoutingLatencyTolerance = value; }
    public float getIPSyncLatencyFraction() { return IPSyncLatencyFraction; }
    public void setIPSyncLatencyFraction(float value) { this.IPSyncLatencyFraction = value; }
    public String getDefaultLine() { return DefaultLine; }
    public void setDefaultLine(String value) { this.DefaultLine = value; }
    public String getCompletionStatus() { return CompletionStatus; }
    public void setCompletionStatus(String value) { this.CompletionStatus = value; }
    public String getIPRoutingBackboneSecurity() { return IPRoutingBackboneSecurity; }
    public void setIPRoutingBackboneSecurity(String value) { this.IPRoutingBackboneSecurity = value; }
    public String getSplitType() { return SplitType; }
    public void setSplitType(String value) { this.SplitType = value; }
    public Topology getTopology() { return Topology; }
    public void setTopology(Topology value) { this.Topology = value; }
    public Locations getLocations() { return Locations; }
    public void setLocations(Locations value) { this.Locations = value; }
    public GroupAddresses getGroupAddresses() { return GroupAddresses; }
    public void setGroupAddresses(GroupAddresses value) { this.GroupAddresses = value; }
    public P2PLinks getP2PLinks() { return P2PLinks; }
    public void setP2PLinks(P2PLinks value) { this.P2PLinks = value; }
    public Trades getTrades() { return Trades; }
    public void setTrades(Trades value) { this.Trades = value; }
    public SplitInfos getSplitInfos() { return SplitInfos; }
    public void setSplitInfos(SplitInfos value) { this.SplitInfos = value; }
}