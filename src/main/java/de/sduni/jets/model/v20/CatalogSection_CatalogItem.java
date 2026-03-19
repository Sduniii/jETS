package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CatalogSection_CatalogItem extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Number")
    private int Number;
    @JacksonXmlProperty(isAttribute = true, localName = "VisibleDescription")
    private String VisibleDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "ProductRefId")
    private String ProductRefId;
    @JacksonXmlProperty(isAttribute = true, localName = "Hardware2ProgramRefId")
    private String Hardware2ProgramRefId;
    @JacksonXmlProperty(isAttribute = true, localName = "DefaultLanguage")
    private String DefaultLanguage;
    @JacksonXmlProperty(isAttribute = true, localName = "NonRegRelevantDataVersion")
    private int NonRegRelevantDataVersion;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public int getNumber() { return Number; }
    public void setNumber(int value) { this.Number = value; }
    public String getVisibleDescription() { return VisibleDescription; }
    public void setVisibleDescription(String value) { this.VisibleDescription = value; }
    public String getProductRefId() { return ProductRefId; }
    public void setProductRefId(String value) { this.ProductRefId = value; }
    public String getHardware2ProgramRefId() { return Hardware2ProgramRefId; }
    public void setHardware2ProgramRefId(String value) { this.Hardware2ProgramRefId = value; }
    public String getDefaultLanguage() { return DefaultLanguage; }
    public void setDefaultLanguage(String value) { this.DefaultLanguage = value; }
    public int getNonRegRelevantDataVersion() { return NonRegRelevantDataVersion; }
    public void setNonRegRelevantDataVersion(int value) { this.NonRegRelevantDataVersion = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
}