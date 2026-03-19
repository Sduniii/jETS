package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupAddresses_GroupRanges extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "GroupRange")
    private java.util.List<GroupRange> GroupRange = new java.util.ArrayList<>();

    public java.util.List<GroupRange> getGroupRange() { return GroupRange; }
    public void setGroupRange(java.util.List<GroupRange> value) { this.GroupRange = value; }
}