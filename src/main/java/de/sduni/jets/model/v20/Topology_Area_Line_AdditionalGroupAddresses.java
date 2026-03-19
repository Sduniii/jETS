package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Topology_Area_Line_AdditionalGroupAddresses extends KnxBase {
    @JacksonXmlProperty(localName = "GroupAddress")
    private Topology_Area_Line_AdditionalGroupAddresses_GroupAddress GroupAddress = null;

    public Topology_Area_Line_AdditionalGroupAddresses_GroupAddress getGroupAddress() { return GroupAddress; }
    public void setGroupAddress(Topology_Area_Line_AdditionalGroupAddresses_GroupAddress value) { this.GroupAddress = value; }
}