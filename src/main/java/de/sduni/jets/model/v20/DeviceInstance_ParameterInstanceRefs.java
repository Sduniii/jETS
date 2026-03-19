package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceInstance_ParameterInstanceRefs extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ParameterInstanceRef")
    private java.util.List<ParameterInstanceRef> ParameterInstanceRef = new java.util.ArrayList<>();

    public java.util.List<ParameterInstanceRef> getParameterInstanceRef() { return ParameterInstanceRef; }
    public void setParameterInstanceRef(java.util.List<ParameterInstanceRef> value) { this.ParameterInstanceRef = value; }
}