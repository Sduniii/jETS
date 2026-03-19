package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Node_Nodes extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Node")
    private java.util.List<Node> Node = new java.util.ArrayList<>();

    public java.util.List<Node> getNode() { return Node; }
    public void setNode(java.util.List<Node> value) { this.Node = value; }
}