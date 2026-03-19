package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic_Extension extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "EtsDownloadPlugin")
    private String EtsDownloadPlugin;
    @JacksonXmlProperty(isAttribute = true, localName = "EtsUiPlugin")
    private String EtsUiPlugin;
    @JacksonXmlProperty(isAttribute = true, localName = "EtsDataHandler")
    private String EtsDataHandler;
    @JacksonXmlProperty(isAttribute = true, localName = "EtsDataHandlerCapabilities")
    private String EtsDataHandlerCapabilities;
    @JacksonXmlProperty(isAttribute = true, localName = "RequiresExternalSoftware")
    private boolean RequiresExternalSoftware;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Baggage")
    private java.util.List<ApplicationProgramStatic_Extension_Baggage> Baggage = new java.util.ArrayList<>();

    public String getEtsDownloadPlugin() { return EtsDownloadPlugin; }
    public void setEtsDownloadPlugin(String value) { this.EtsDownloadPlugin = value; }
    public String getEtsUiPlugin() { return EtsUiPlugin; }
    public void setEtsUiPlugin(String value) { this.EtsUiPlugin = value; }
    public String getEtsDataHandler() { return EtsDataHandler; }
    public void setEtsDataHandler(String value) { this.EtsDataHandler = value; }
    public String getEtsDataHandlerCapabilities() { return EtsDataHandlerCapabilities; }
    public void setEtsDataHandlerCapabilities(String value) { this.EtsDataHandlerCapabilities = value; }
    public boolean getRequiresExternalSoftware() { return RequiresExternalSoftware; }
    public void setRequiresExternalSoftware(boolean value) { this.RequiresExternalSoftware = value; }
    public java.util.List<ApplicationProgramStatic_Extension_Baggage> getBaggage() { return Baggage; }
    public void setBaggage(java.util.List<ApplicationProgramStatic_Extension_Baggage> value) { this.Baggage = value; }
}