package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project_AddinData extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "AddinData")
    private java.util.List<AddinData> AddinData = new java.util.ArrayList<>();

    public java.util.List<AddinData> getAddinData() { return AddinData; }
    public void setAddinData(java.util.List<AddinData> value) { this.AddinData = value; }
}