package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HawkConfigurationData_MemorySegments extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "MemorySegment")
    private java.util.List<HawkConfigurationData_MemorySegments_MemorySegment> MemorySegment = new java.util.ArrayList<>();

    public java.util.List<HawkConfigurationData_MemorySegments_MemorySegment> getMemorySegment() { return MemorySegment; }
    public void setMemorySegment(java.util.List<HawkConfigurationData_MemorySegments_MemorySegment> value) { this.MemorySegment = value; }
}