package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project_Installations extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Installation")
    private java.util.List<Project_Installations_Installation> Installation = new java.util.ArrayList<>();

    public java.util.List<Project_Installations_Installation> getInstallation() { return Installation; }
    public void setInstallation(java.util.List<Project_Installations_Installation> value) { this.Installation = value; }
}