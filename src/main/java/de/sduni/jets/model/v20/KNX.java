package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KNX extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "CreatedBy")
    private String CreatedBy;
    @JacksonXmlProperty(isAttribute = true, localName = "ToolVersion")
    private String ToolVersion;
    @JacksonXmlProperty(localName = "MasterData")
    private MasterData MasterData = null;
    @JacksonXmlProperty(localName = "ManufacturerData")
    private ManufacturerData ManufacturerData = null;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Project")
    private java.util.List<Project> Project = new java.util.ArrayList<>();

    public String getCreatedBy() { return CreatedBy; }
    public void setCreatedBy(String value) { this.CreatedBy = value; }
    public String getToolVersion() { return ToolVersion; }
    public void setToolVersion(String value) { this.ToolVersion = value; }
    public MasterData getMasterData() { return MasterData; }
    public void setMasterData(MasterData value) { this.MasterData = value; }
    public ManufacturerData getManufacturerData() { return ManufacturerData; }
    public void setManufacturerData(ManufacturerData value) { this.ManufacturerData = value; }
    public java.util.List<Project> getProject() { return Project; }
    public void setProject(java.util.List<Project> value) { this.Project = value; }

    /**
     * Finds the product name (text) for a given productRefId by searching through manufacturer data.
     */
    public String findProductName(String productRefId) {
        if (productRefId == null || ManufacturerData == null) return null;
        for (ManufacturerData_Manufacturer m : ManufacturerData.getManufacturer()) {
            if (m.getHardware() != null) {
                for (Hardware h : m.getHardware().getHardware()) {
                    if (h.getProducts() != null) {
                        for (Hardware_Products_Product p : h.getProducts().getProduct()) {
                            if (productRefId.equals(p.getId())) {
                                return p.getText();
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
