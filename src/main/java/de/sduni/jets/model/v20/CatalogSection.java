package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CatalogSection extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Number")
    private String Number;
    @JacksonXmlProperty(isAttribute = true, localName = "VisibleDescription")
    private String VisibleDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "DefaultLanguage")
    private String DefaultLanguage;
    @JacksonXmlProperty(isAttribute = true, localName = "NonRegRelevantDataVersion")
    private int NonRegRelevantDataVersion;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "CatalogSection")
    private java.util.List<CatalogSection> CatalogSection = new java.util.ArrayList<>();
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "CatalogItem")
    private java.util.List<CatalogSection_CatalogItem> CatalogItem = new java.util.ArrayList<>();

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getNumber() { return Number; }
    public void setNumber(String value) { this.Number = value; }
    public String getVisibleDescription() { return VisibleDescription; }
    public void setVisibleDescription(String value) { this.VisibleDescription = value; }
    public String getDefaultLanguage() { return DefaultLanguage; }
    public void setDefaultLanguage(String value) { this.DefaultLanguage = value; }
    public int getNonRegRelevantDataVersion() { return NonRegRelevantDataVersion; }
    public void setNonRegRelevantDataVersion(int value) { this.NonRegRelevantDataVersion = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public java.util.List<CatalogSection> getCatalogSection() { return CatalogSection; }
    public void setCatalogSection(java.util.List<CatalogSection> value) { this.CatalogSection = value; }
    public java.util.List<CatalogSection_CatalogItem> getCatalogItem() { return CatalogItem; }
    public void setCatalogItem(java.util.List<CatalogSection_CatalogItem> value) { this.CatalogItem = value; }
}