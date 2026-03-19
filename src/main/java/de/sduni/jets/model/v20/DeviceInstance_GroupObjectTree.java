package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceInstance_GroupObjectTree extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "GroupObjectInstances")
    private String GroupObjectInstances;
    @JacksonXmlProperty(localName = "Nodes")
    private DeviceInstance_GroupObjectTree_Nodes Nodes = null;

    public String getGroupObjectInstances() { return GroupObjectInstances; }
    public void setGroupObjectInstances(String value) { this.GroupObjectInstances = value; }
    public DeviceInstance_GroupObjectTree_Nodes getNodes() { return Nodes; }
    public void setNodes(DeviceInstance_GroupObjectTree_Nodes value) { this.Nodes = value; }
}