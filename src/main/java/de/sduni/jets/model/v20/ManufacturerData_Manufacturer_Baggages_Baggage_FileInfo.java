package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ManufacturerData_Manufacturer_Baggages_Baggage_FileInfo extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Version")
    private String Version;
    @JacksonXmlProperty(isAttribute = true, localName = "TimeInfo")
    private java.time.LocalDateTime TimeInfo;
    @JacksonXmlProperty(isAttribute = true, localName = "Hidden")
    private boolean Hidden;
    @JacksonXmlProperty(isAttribute = true, localName = "ReadOnly")
    private boolean ReadOnly;

    public String getVersion() { return Version; }
    public void setVersion(String value) { this.Version = value; }
    public java.time.LocalDateTime getTimeInfo() { return TimeInfo; }
    public void setTimeInfo(java.time.LocalDateTime value) { this.TimeInfo = value; }
    public boolean getHidden() { return Hidden; }
    public void setHidden(boolean value) { this.Hidden = value; }
    public boolean getReadOnly() { return ReadOnly; }
    public void setReadOnly(boolean value) { this.ReadOnly = value; }
}