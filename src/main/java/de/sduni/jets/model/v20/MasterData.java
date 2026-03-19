package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Version")
    private long Version;
    @JacksonXmlProperty(isAttribute = true, localName = "Signature")
    private byte[] Signature;
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(localName = "DatapointTypes")
    private MasterData_DatapointTypes DatapointTypes = null;
    @JacksonXmlProperty(localName = "DatapointRoles")
    private MasterData_DatapointRoles DatapointRoles = null;
    @JacksonXmlProperty(localName = "InterfaceObjectTypes")
    private MasterData_InterfaceObjectTypes InterfaceObjectTypes = null;
    @JacksonXmlProperty(localName = "InterfaceObjectProperties")
    private MasterData_InterfaceObjectProperties InterfaceObjectProperties = null;
    @JacksonXmlProperty(localName = "PropertyDataTypes")
    private MasterData_PropertyDataTypes PropertyDataTypes = null;
    @JacksonXmlProperty(localName = "MediumTypes")
    private MasterData_MediumTypes MediumTypes = null;
    @JacksonXmlProperty(localName = "MaskVersions")
    private MasterData_MaskVersions MaskVersions = null;
    @JacksonXmlProperty(localName = "FunctionalBlocks")
    private MasterData_FunctionalBlocks FunctionalBlocks = null;
    @JacksonXmlProperty(localName = "ProductLanguages")
    private MasterData_ProductLanguages ProductLanguages = null;
    @JacksonXmlProperty(localName = "FunctionTypes")
    private MasterData_FunctionTypes FunctionTypes = null;
    @JacksonXmlProperty(localName = "SpaceUsages")
    private MasterData_SpaceUsages SpaceUsages = null;
    @JacksonXmlProperty(localName = "Manufacturers")
    private MasterData_Manufacturers Manufacturers = null;
    @JacksonXmlProperty(localName = "Languages")
    private MasterData_Languages Languages = null;

    public long getVersion() { return Version; }
    public void setVersion(long value) { this.Version = value; }
    public byte[] getSignature() { return Signature; }
    public void setSignature(byte[] value) { this.Signature = value; }
    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public MasterData_DatapointTypes getDatapointTypes() { return DatapointTypes; }
    public void setDatapointTypes(MasterData_DatapointTypes value) { this.DatapointTypes = value; }
    public MasterData_DatapointRoles getDatapointRoles() { return DatapointRoles; }
    public void setDatapointRoles(MasterData_DatapointRoles value) { this.DatapointRoles = value; }
    public MasterData_InterfaceObjectTypes getInterfaceObjectTypes() { return InterfaceObjectTypes; }
    public void setInterfaceObjectTypes(MasterData_InterfaceObjectTypes value) { this.InterfaceObjectTypes = value; }
    public MasterData_InterfaceObjectProperties getInterfaceObjectProperties() { return InterfaceObjectProperties; }
    public void setInterfaceObjectProperties(MasterData_InterfaceObjectProperties value) { this.InterfaceObjectProperties = value; }
    public MasterData_PropertyDataTypes getPropertyDataTypes() { return PropertyDataTypes; }
    public void setPropertyDataTypes(MasterData_PropertyDataTypes value) { this.PropertyDataTypes = value; }
    public MasterData_MediumTypes getMediumTypes() { return MediumTypes; }
    public void setMediumTypes(MasterData_MediumTypes value) { this.MediumTypes = value; }
    public MasterData_MaskVersions getMaskVersions() { return MaskVersions; }
    public void setMaskVersions(MasterData_MaskVersions value) { this.MaskVersions = value; }
    public MasterData_FunctionalBlocks getFunctionalBlocks() { return FunctionalBlocks; }
    public void setFunctionalBlocks(MasterData_FunctionalBlocks value) { this.FunctionalBlocks = value; }
    public MasterData_ProductLanguages getProductLanguages() { return ProductLanguages; }
    public void setProductLanguages(MasterData_ProductLanguages value) { this.ProductLanguages = value; }
    public MasterData_FunctionTypes getFunctionTypes() { return FunctionTypes; }
    public void setFunctionTypes(MasterData_FunctionTypes value) { this.FunctionTypes = value; }
    public MasterData_SpaceUsages getSpaceUsages() { return SpaceUsages; }
    public void setSpaceUsages(MasterData_SpaceUsages value) { this.SpaceUsages = value; }
    public MasterData_Manufacturers getManufacturers() { return Manufacturers; }
    public void setManufacturers(MasterData_Manufacturers value) { this.Manufacturers = value; }
    public MasterData_Languages getLanguages() { return Languages; }
    public void setLanguages(MasterData_Languages value) { this.Languages = value; }
}