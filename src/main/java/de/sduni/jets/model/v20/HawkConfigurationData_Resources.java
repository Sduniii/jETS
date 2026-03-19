package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HawkConfigurationData_Resources extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Resource")
    private java.util.List<HawkConfigurationData_Resources_Resource> Resource = new java.util.ArrayList<>();

    public java.util.List<HawkConfigurationData_Resources_Resource> getResource() { return Resource; }
    public void setResource(java.util.List<HawkConfigurationData_Resources_Resource> value) { this.Resource = value; }
}