package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic extends KnxBase {
    @JacksonXmlProperty(localName = "Code")
    private ApplicationProgramStatic_Code Code = null;
    @JacksonXmlProperty(localName = "ParameterTypes")
    private ApplicationProgramStatic_ParameterTypes ParameterTypes = null;
    @JacksonXmlProperty(localName = "Parameters")
    private ApplicationProgramStatic_Parameters Parameters = null;
    @JacksonXmlProperty(localName = "ParameterRefs")
    private ApplicationProgramStatic_ParameterRefs ParameterRefs = null;
    @JacksonXmlProperty(localName = "ParameterCalculations")
    private ApplicationProgramStatic_ParameterCalculations ParameterCalculations = null;
    @JacksonXmlProperty(localName = "ParameterValidations")
    private ApplicationProgramStatic_ParameterValidations ParameterValidations = null;
    @JacksonXmlProperty(localName = "ComObjectTable")
    private ApplicationProgramStatic_ComObjectTable ComObjectTable = null;
    @JacksonXmlProperty(localName = "ComObjectRefs")
    private ApplicationProgramStatic_ComObjectRefs ComObjectRefs = null;
    @JacksonXmlProperty(localName = "AddressTable")
    private ApplicationProgramStatic_AddressTable AddressTable = null;
    @JacksonXmlProperty(localName = "AssociationTable")
    private ApplicationProgramStatic_AssociationTable AssociationTable = null;
    @JacksonXmlProperty(localName = "FixupList")
    private ApplicationProgramStatic_FixupList FixupList = null;
    @JacksonXmlProperty(localName = "LoadProcedures")
    private LoadProcedures LoadProcedures = null;
    @JacksonXmlProperty(localName = "Extension")
    private ApplicationProgramStatic_Extension Extension = null;
    @JacksonXmlProperty(localName = "BinaryData")
    private ApplicationProgramStatic_BinaryData BinaryData = null;
    @JacksonXmlProperty(localName = "DeviceCompare")
    private ApplicationProgramStatic_DeviceCompare DeviceCompare = null;
    @JacksonXmlProperty(localName = "Messages")
    private ApplicationProgramStatic_Messages Messages = null;
    @JacksonXmlProperty(localName = "Script")
    private ApplicationProgramStatic_Script Script = null;
    @JacksonXmlProperty(localName = "SecurityRoles")
    private ApplicationProgramStatic_SecurityRoles SecurityRoles = null;
    @JacksonXmlProperty(localName = "BusInterfaces")
    private ApplicationProgramStatic_BusInterfaces BusInterfaces = null;
    @JacksonXmlProperty(localName = "Allocators")
    private ApplicationProgramStatic_Allocators Allocators = null;
    @JacksonXmlProperty(localName = "Options")
    private ApplicationProgramStatic_Options Options = null;

    public ApplicationProgramStatic_Code getCode() { return Code; }
    public void setCode(ApplicationProgramStatic_Code value) { this.Code = value; }
    public ApplicationProgramStatic_ParameterTypes getParameterTypes() { return ParameterTypes; }
    public void setParameterTypes(ApplicationProgramStatic_ParameterTypes value) { this.ParameterTypes = value; }
    public ApplicationProgramStatic_Parameters getParameters() { return Parameters; }
    public void setParameters(ApplicationProgramStatic_Parameters value) { this.Parameters = value; }
    public ApplicationProgramStatic_ParameterRefs getParameterRefs() { return ParameterRefs; }
    public void setParameterRefs(ApplicationProgramStatic_ParameterRefs value) { this.ParameterRefs = value; }
    public ApplicationProgramStatic_ParameterCalculations getParameterCalculations() { return ParameterCalculations; }
    public void setParameterCalculations(ApplicationProgramStatic_ParameterCalculations value) { this.ParameterCalculations = value; }
    public ApplicationProgramStatic_ParameterValidations getParameterValidations() { return ParameterValidations; }
    public void setParameterValidations(ApplicationProgramStatic_ParameterValidations value) { this.ParameterValidations = value; }
    public ApplicationProgramStatic_ComObjectTable getComObjectTable() { return ComObjectTable; }
    public void setComObjectTable(ApplicationProgramStatic_ComObjectTable value) { this.ComObjectTable = value; }
    public ApplicationProgramStatic_ComObjectRefs getComObjectRefs() { return ComObjectRefs; }
    public void setComObjectRefs(ApplicationProgramStatic_ComObjectRefs value) { this.ComObjectRefs = value; }
    public ApplicationProgramStatic_AddressTable getAddressTable() { return AddressTable; }
    public void setAddressTable(ApplicationProgramStatic_AddressTable value) { this.AddressTable = value; }
    public ApplicationProgramStatic_AssociationTable getAssociationTable() { return AssociationTable; }
    public void setAssociationTable(ApplicationProgramStatic_AssociationTable value) { this.AssociationTable = value; }
    public ApplicationProgramStatic_FixupList getFixupList() { return FixupList; }
    public void setFixupList(ApplicationProgramStatic_FixupList value) { this.FixupList = value; }
    public LoadProcedures getLoadProcedures() { return LoadProcedures; }
    public void setLoadProcedures(LoadProcedures value) { this.LoadProcedures = value; }
    public ApplicationProgramStatic_Extension getExtension() { return Extension; }
    public void setExtension(ApplicationProgramStatic_Extension value) { this.Extension = value; }
    public ApplicationProgramStatic_BinaryData getBinaryData() { return BinaryData; }
    public void setBinaryData(ApplicationProgramStatic_BinaryData value) { this.BinaryData = value; }
    public ApplicationProgramStatic_DeviceCompare getDeviceCompare() { return DeviceCompare; }
    public void setDeviceCompare(ApplicationProgramStatic_DeviceCompare value) { this.DeviceCompare = value; }
    public ApplicationProgramStatic_Messages getMessages() { return Messages; }
    public void setMessages(ApplicationProgramStatic_Messages value) { this.Messages = value; }
    public ApplicationProgramStatic_Script getScript() { return Script; }
    public void setScript(ApplicationProgramStatic_Script value) { this.Script = value; }
    public ApplicationProgramStatic_SecurityRoles getSecurityRoles() { return SecurityRoles; }
    public void setSecurityRoles(ApplicationProgramStatic_SecurityRoles value) { this.SecurityRoles = value; }
    public ApplicationProgramStatic_BusInterfaces getBusInterfaces() { return BusInterfaces; }
    public void setBusInterfaces(ApplicationProgramStatic_BusInterfaces value) { this.BusInterfaces = value; }
    public ApplicationProgramStatic_Allocators getAllocators() { return Allocators; }
    public void setAllocators(ApplicationProgramStatic_Allocators value) { this.Allocators = value; }
    public ApplicationProgramStatic_Options getOptions() { return Options; }
    public void setOptions(ApplicationProgramStatic_Options value) { this.Options = value; }
}