package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ToDoItem extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Description")
    private String Description;
    @JacksonXmlProperty(isAttribute = true, localName = "ObjectPath")
    private String ObjectPath;
    @JacksonXmlProperty(isAttribute = true, localName = "Status")
    private String Status;

    public String getDescription() { return Description; }
    public void setDescription(String value) { this.Description = value; }
    public String getObjectPath() { return ObjectPath; }
    public void setObjectPath(String value) { this.ObjectPath = value; }
    public String getStatus() { return Status; }
    public void setStatus(String value) { this.Status = value; }
}