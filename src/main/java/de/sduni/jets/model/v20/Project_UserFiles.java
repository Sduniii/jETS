package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project_UserFiles extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "UserFile")
    private java.util.List<UserFile> UserFile = new java.util.ArrayList<>();

    public java.util.List<UserFile> getUserFile() { return UserFile; }
    public void setUserFile(java.util.List<UserFile> value) { this.UserFile = value; }
}