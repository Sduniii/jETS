package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HawkConfigurationData extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Ets3SystemPlugin")
    private String Ets3SystemPlugin;
    @JacksonXmlProperty(isAttribute = true, localName = "LegacyVersion")
    private int LegacyVersion;
    @JacksonXmlProperty(localName = "Features")
    private HawkConfigurationData_Features Features = null;
    @JacksonXmlProperty(localName = "Resources")
    private HawkConfigurationData_Resources Resources = null;
    @JacksonXmlProperty(localName = "Procedures")
    private HawkConfigurationData_Procedures Procedures = null;
    @JacksonXmlProperty(localName = "MemorySegments")
    private HawkConfigurationData_MemorySegments MemorySegments = null;
    @JacksonXmlProperty(localName = "InterfaceObjects")
    private HawkConfigurationData_InterfaceObjects InterfaceObjects = null;

    public String getEts3SystemPlugin() { return Ets3SystemPlugin; }
    public void setEts3SystemPlugin(String value) { this.Ets3SystemPlugin = value; }
    public int getLegacyVersion() { return LegacyVersion; }
    public void setLegacyVersion(int value) { this.LegacyVersion = value; }
    public HawkConfigurationData_Features getFeatures() { return Features; }
    public void setFeatures(HawkConfigurationData_Features value) { this.Features = value; }
    public HawkConfigurationData_Resources getResources() { return Resources; }
    public void setResources(HawkConfigurationData_Resources value) { this.Resources = value; }
    public HawkConfigurationData_Procedures getProcedures() { return Procedures; }
    public void setProcedures(HawkConfigurationData_Procedures value) { this.Procedures = value; }
    public HawkConfigurationData_MemorySegments getMemorySegments() { return MemorySegments; }
    public void setMemorySegments(HawkConfigurationData_MemorySegments value) { this.MemorySegments = value; }
    public HawkConfigurationData_InterfaceObjects getInterfaceObjects() { return InterfaceObjects; }
    public void setInterfaceObjects(HawkConfigurationData_InterfaceObjects value) { this.InterfaceObjects = value; }
}