package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Node extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Type")
    private String Type;
    @JacksonXmlProperty(isAttribute = true, localName = "RefId")
    private String RefId;
    @JacksonXmlProperty(isAttribute = true, localName = "Text")
    private String Text;
    @JacksonXmlProperty(isAttribute = true, localName = "GroupObjectInstances")
    private String GroupObjectInstances;
    @JacksonXmlProperty(localName = "Nodes")
    private Node_Nodes Nodes = null;

    public String getType() { return Type; }
    public void setType(String value) { this.Type = value; }
    public String getRefId() { return RefId; }
    public void setRefId(String value) { this.RefId = value; }
    public String getText() { return Text; }
    public void setText(String value) { this.Text = value; }
    public String getGroupObjectInstances() { return GroupObjectInstances; }
    public void setGroupObjectInstances(String value) { this.GroupObjectInstances = value; }
    public Node_Nodes getNodes() { return Nodes; }
    public void setNodes(Node_Nodes value) { this.Nodes = value; }
}