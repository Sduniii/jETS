package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleDefStatic extends KnxBase {
    @JacksonXmlProperty(localName = "Parameters")
    private ModuleDefStatic_Parameters Parameters = null;
    @JacksonXmlProperty(localName = "ParameterRefs")
    private ModuleDefStatic_ParameterRefs ParameterRefs = null;
    @JacksonXmlProperty(localName = "ParameterCalculations")
    private ModuleDefStatic_ParameterCalculations ParameterCalculations = null;
    @JacksonXmlProperty(localName = "ParameterValidations")
    private ModuleDefStatic_ParameterValidations ParameterValidations = null;
    @JacksonXmlProperty(localName = "ComObjects")
    private ModuleDefStatic_ComObjects ComObjects = null;
    @JacksonXmlProperty(localName = "ComObjectRefs")
    private ModuleDefStatic_ComObjectRefs ComObjectRefs = null;
    @JacksonXmlProperty(localName = "LoadProcedures")
    private ModuleDefLoadProcedures LoadProcedures = null;
    @JacksonXmlProperty(localName = "Allocators")
    private ModuleDefStatic_Allocators Allocators = null;

    public ModuleDefStatic_Parameters getParameters() { return Parameters; }
    public void setParameters(ModuleDefStatic_Parameters value) { this.Parameters = value; }
    public ModuleDefStatic_ParameterRefs getParameterRefs() { return ParameterRefs; }
    public void setParameterRefs(ModuleDefStatic_ParameterRefs value) { this.ParameterRefs = value; }
    public ModuleDefStatic_ParameterCalculations getParameterCalculations() { return ParameterCalculations; }
    public void setParameterCalculations(ModuleDefStatic_ParameterCalculations value) { this.ParameterCalculations = value; }
    public ModuleDefStatic_ParameterValidations getParameterValidations() { return ParameterValidations; }
    public void setParameterValidations(ModuleDefStatic_ParameterValidations value) { this.ParameterValidations = value; }
    public ModuleDefStatic_ComObjects getComObjects() { return ComObjects; }
    public void setComObjects(ModuleDefStatic_ComObjects value) { this.ComObjects = value; }
    public ModuleDefStatic_ComObjectRefs getComObjectRefs() { return ComObjectRefs; }
    public void setComObjectRefs(ModuleDefStatic_ComObjectRefs value) { this.ComObjectRefs = value; }
    public ModuleDefLoadProcedures getLoadProcedures() { return LoadProcedures; }
    public void setLoadProcedures(ModuleDefLoadProcedures value) { this.LoadProcedures = value; }
    public ModuleDefStatic_Allocators getAllocators() { return Allocators; }
    public void setAllocators(ModuleDefStatic_Allocators value) { this.Allocators = value; }
}