package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ManufacturerData_Manufacturer extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "RefId")
    private String RefId;
    @JacksonXmlProperty(localName = "Catalog")
    private ManufacturerData_Manufacturer_Catalog Catalog = null;
    @JacksonXmlProperty(localName = "ApplicationPrograms")
    private ManufacturerData_Manufacturer_ApplicationPrograms ApplicationPrograms = null;
    @JacksonXmlProperty(localName = "Baggages")
    private ManufacturerData_Manufacturer_Baggages Baggages = null;
    @JacksonXmlProperty(localName = "Hardware")
    private ManufacturerData_Manufacturer_Hardware Hardware = null;
    @JacksonXmlProperty(localName = "Languages")
    private ManufacturerData_Manufacturer_Languages Languages = null;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getRefId() { return RefId; }
    public void setRefId(String value) { this.RefId = value; }
    public ManufacturerData_Manufacturer_Catalog getCatalog() { return Catalog; }
    public void setCatalog(ManufacturerData_Manufacturer_Catalog value) { this.Catalog = value; }
    public ManufacturerData_Manufacturer_ApplicationPrograms getApplicationPrograms() { return ApplicationPrograms; }
    public void setApplicationPrograms(ManufacturerData_Manufacturer_ApplicationPrograms value) { this.ApplicationPrograms = value; }
    public ManufacturerData_Manufacturer_Baggages getBaggages() { return Baggages; }
    public void setBaggages(ManufacturerData_Manufacturer_Baggages value) { this.Baggages = value; }
    public ManufacturerData_Manufacturer_Hardware getHardware() { return Hardware; }
    public void setHardware(ManufacturerData_Manufacturer_Hardware value) { this.Hardware = value; }
    public ManufacturerData_Manufacturer_Languages getLanguages() { return Languages; }
    public void setLanguages(ManufacturerData_Manufacturer_Languages value) { this.Languages = value; }
}
