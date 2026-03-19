package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceInstance_ModuleInstances extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ModuleInstance")
    private java.util.List<ModuleInstance> ModuleInstance = new java.util.ArrayList<>();

    public java.util.List<ModuleInstance> getModuleInstance() { return ModuleInstance; }
    public void setModuleInstance(java.util.List<ModuleInstance> value) { this.ModuleInstance = value; }
}