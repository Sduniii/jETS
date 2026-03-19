package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(localName = "ProjectInformation")
    private Project_ProjectInformation ProjectInformation = null;
    @JacksonXmlProperty(localName = "Installations")
    private Project_Installations Installations = null;
    @JacksonXmlProperty(localName = "UserFiles")
    private Project_UserFiles UserFiles = null;
    @JacksonXmlProperty(localName = "AddinData")
    private Project_AddinData AddinData = null;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public Project_ProjectInformation getProjectInformation() { return ProjectInformation; }
    public void setProjectInformation(Project_ProjectInformation value) { this.ProjectInformation = value; }
    public Project_Installations getInstallations() { return Installations; }
    public void setInstallations(Project_Installations value) { this.Installations = value; }
    public Project_UserFiles getUserFiles() { return UserFiles; }
    public void setUserFiles(Project_UserFiles value) { this.UserFiles = value; }
    public Project_AddinData getAddinData() { return AddinData; }
    public void setAddinData(Project_AddinData value) { this.AddinData = value; }
}