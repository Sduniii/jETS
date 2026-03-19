package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hardware_Products_Product extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Text")
    private String Text;
    @JacksonXmlProperty(isAttribute = true, localName = "OrderNumber")
    private String OrderNumber;
    @JacksonXmlProperty(isAttribute = true, localName = "IsRailMounted")
    private boolean IsRailMounted;
    @JacksonXmlProperty(isAttribute = true, localName = "WidthInMillimeter")
    private float WidthInMillimeter;
    @JacksonXmlProperty(isAttribute = true, localName = "VisibleDescription")
    private String VisibleDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "DefaultLanguage")
    private String DefaultLanguage;
    @JacksonXmlProperty(isAttribute = true, localName = "NonRegRelevantDataVersion")
    private int NonRegRelevantDataVersion;
    @JacksonXmlProperty(isAttribute = true, localName = "Hash")
    private byte[] Hash;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlProperty(localName = "Baggages")
    private Hardware_Products_Product_Baggages Baggages = null;
    @JacksonXmlProperty(localName = "Attributes")
    private Hardware_Products_Product_Attributes Attributes = null;
    @JacksonXmlProperty(localName = "RegistrationInfo")
    private RegistrationInfo RegistrationInfo = null;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getText() { return Text; }
    public void setText(String value) { this.Text = value; }
    public String getOrderNumber() { return OrderNumber; }
    public void setOrderNumber(String value) { this.OrderNumber = value; }
    public boolean getIsRailMounted() { return IsRailMounted; }
    public void setIsRailMounted(boolean value) { this.IsRailMounted = value; }
    public float getWidthInMillimeter() { return WidthInMillimeter; }
    public void setWidthInMillimeter(float value) { this.WidthInMillimeter = value; }
    public String getVisibleDescription() { return VisibleDescription; }
    public void setVisibleDescription(String value) { this.VisibleDescription = value; }
    public String getDefaultLanguage() { return DefaultLanguage; }
    public void setDefaultLanguage(String value) { this.DefaultLanguage = value; }
    public int getNonRegRelevantDataVersion() { return NonRegRelevantDataVersion; }
    public void setNonRegRelevantDataVersion(int value) { this.NonRegRelevantDataVersion = value; }
    public byte[] getHash() { return Hash; }
    public void setHash(byte[] value) { this.Hash = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public Hardware_Products_Product_Baggages getBaggages() { return Baggages; }
    public void setBaggages(Hardware_Products_Product_Baggages value) { this.Baggages = value; }
    public Hardware_Products_Product_Attributes getAttributes() { return Attributes; }
    public void setAttributes(Hardware_Products_Product_Attributes value) { this.Attributes = value; }
    public RegistrationInfo getRegistrationInfo() { return RegistrationInfo; }
    public void setRegistrationInfo(RegistrationInfo value) { this.RegistrationInfo = value; }
}