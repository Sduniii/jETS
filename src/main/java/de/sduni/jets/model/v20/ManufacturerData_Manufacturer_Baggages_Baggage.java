package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ManufacturerData_Manufacturer_Baggages_Baggage extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "TargetPath")
    private String TargetPath;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "FileIntegrity")
    private String FileIntegrity;
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(localName = "FileInfo")
    private ManufacturerData_Manufacturer_Baggages_Baggage_FileInfo FileInfo = null;

    public String getTargetPath() { return TargetPath; }
    public void setTargetPath(String value) { this.TargetPath = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getFileIntegrity() { return FileIntegrity; }
    public void setFileIntegrity(String value) { this.FileIntegrity = value; }
    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public ManufacturerData_Manufacturer_Baggages_Baggage_FileInfo getFileInfo() { return FileInfo; }
    public void setFileInfo(ManufacturerData_Manufacturer_Baggages_Baggage_FileInfo value) { this.FileInfo = value; }
}