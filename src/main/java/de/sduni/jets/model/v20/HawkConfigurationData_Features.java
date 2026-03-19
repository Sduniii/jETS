package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HawkConfigurationData_Features extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Feature")
    private java.util.List<HawkConfigurationData_Features_Feature> Feature = new java.util.ArrayList<>();

    public java.util.List<HawkConfigurationData_Features_Feature> getFeature() { return Feature; }
    public void setFeature(java.util.List<HawkConfigurationData_Features_Feature> value) { this.Feature = value; }
}