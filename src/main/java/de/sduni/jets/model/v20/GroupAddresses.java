package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupAddresses extends KnxBase {
    @JacksonXmlProperty(localName = "GroupRanges")
    private GroupAddresses_GroupRanges GroupRanges = null;

    public GroupAddresses_GroupRanges getGroupRanges() { return GroupRanges; }
    public void setGroupRanges(GroupAddresses_GroupRanges value) { this.GroupRanges = value; }
}