package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project_ProjectInformation_ToDoItems extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ToDoItem")
    private java.util.List<ToDoItem> ToDoItem = new java.util.ArrayList<>();

    public java.util.List<ToDoItem> getToDoItem() { return ToDoItem; }
    public void setToDoItem(java.util.List<ToDoItem> value) { this.ToDoItem = value; }
}