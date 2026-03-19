package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project_ProjectInformation_ProjectTraces extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ProjectTrace")
    private java.util.List<ProjectTrace> ProjectTrace = new java.util.ArrayList<>();

    public java.util.List<ProjectTrace> getProjectTrace() { return ProjectTrace; }
    public void setProjectTrace(java.util.List<ProjectTrace> value) { this.ProjectTrace = value; }
}