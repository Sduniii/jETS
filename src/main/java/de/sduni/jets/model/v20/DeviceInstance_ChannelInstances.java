package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceInstance_ChannelInstances extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ChannelInstance")
    private java.util.List<ChannelInstance> ChannelInstance = new java.util.ArrayList<>();

    public java.util.List<ChannelInstance> getChannelInstance() { return ChannelInstance; }
    public void setChannelInstance(java.util.List<ChannelInstance> value) { this.ChannelInstance = value; }
}