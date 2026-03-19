package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData_Manufacturers_Manufacturer extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "KnxManufacturerId")
    private int KnxManufacturerId;
    @JacksonXmlProperty(isAttribute = true, localName = "DefaultLanguage")
    private String DefaultLanguage;
    @JacksonXmlProperty(isAttribute = true, localName = "CompatibilityGroup")
    private int CompatibilityGroup;
    @JacksonXmlProperty(isAttribute = true, localName = "ImportRestriction")
    private String ImportRestriction;
    @JacksonXmlProperty(isAttribute = true, localName = "ImportGroup")
    private String ImportGroup;
    @JacksonXmlProperty(isAttribute = true, localName = "OrderNumberWildcardCharacter")
    private String OrderNumberWildcardCharacter;
    @JacksonXmlProperty(isAttribute = true, localName = "MemberStatus")
    private String MemberStatus;
    @JacksonXmlProperty(localName = "PublicKeys")
    private MasterData_Manufacturers_Manufacturer_PublicKeys PublicKeys = null;
    @JacksonXmlProperty(localName = "DatapointTypes")
    private MasterData_Manufacturers_Manufacturer_DatapointTypes DatapointTypes = null;
    @JacksonXmlProperty(localName = "DatapointRoles")
    private MasterData_Manufacturers_Manufacturer_DatapointRoles DatapointRoles = null;
    @JacksonXmlProperty(localName = "FunctionTypes")
    private MasterData_Manufacturers_Manufacturer_FunctionTypes FunctionTypes = null;
    @JacksonXmlProperty(localName = "SpaceUsages")
    private MasterData_Manufacturers_Manufacturer_SpaceUsages SpaceUsages = null;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public int getKnxManufacturerId() { return KnxManufacturerId; }
    public void setKnxManufacturerId(int value) { this.KnxManufacturerId = value; }
    public String getDefaultLanguage() { return DefaultLanguage; }
    public void setDefaultLanguage(String value) { this.DefaultLanguage = value; }
    public int getCompatibilityGroup() { return CompatibilityGroup; }
    public void setCompatibilityGroup(int value) { this.CompatibilityGroup = value; }
    public String getImportRestriction() { return ImportRestriction; }
    public void setImportRestriction(String value) { this.ImportRestriction = value; }
    public String getImportGroup() { return ImportGroup; }
    public void setImportGroup(String value) { this.ImportGroup = value; }
    public String getOrderNumberWildcardCharacter() { return OrderNumberWildcardCharacter; }
    public void setOrderNumberWildcardCharacter(String value) { this.OrderNumberWildcardCharacter = value; }
    public String getMemberStatus() { return MemberStatus; }
    public void setMemberStatus(String value) { this.MemberStatus = value; }
    public MasterData_Manufacturers_Manufacturer_PublicKeys getPublicKeys() { return PublicKeys; }
    public void setPublicKeys(MasterData_Manufacturers_Manufacturer_PublicKeys value) { this.PublicKeys = value; }
    public MasterData_Manufacturers_Manufacturer_DatapointTypes getDatapointTypes() { return DatapointTypes; }
    public void setDatapointTypes(MasterData_Manufacturers_Manufacturer_DatapointTypes value) { this.DatapointTypes = value; }
    public MasterData_Manufacturers_Manufacturer_DatapointRoles getDatapointRoles() { return DatapointRoles; }
    public void setDatapointRoles(MasterData_Manufacturers_Manufacturer_DatapointRoles value) { this.DatapointRoles = value; }
    public MasterData_Manufacturers_Manufacturer_FunctionTypes getFunctionTypes() { return FunctionTypes; }
    public void setFunctionTypes(MasterData_Manufacturers_Manufacturer_FunctionTypes value) { this.FunctionTypes = value; }
    public MasterData_Manufacturers_Manufacturer_SpaceUsages getSpaceUsages() { return SpaceUsages; }
    public void setSpaceUsages(MasterData_Manufacturers_Manufacturer_SpaceUsages value) { this.SpaceUsages = value; }
}