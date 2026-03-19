package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic_Allocators extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Allocator")
    private java.util.List<Allocator> Allocator = new java.util.ArrayList<>();

    public java.util.List<Allocator> getAllocator() { return Allocator; }
    public void setAllocator(java.util.List<Allocator> value) { this.Allocator = value; }
}