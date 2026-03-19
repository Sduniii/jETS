package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Locations extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Space")
    private java.util.List<Space> Space = new java.util.ArrayList<>();

    public java.util.List<Space> getSpace() { return Space; }
    public void setSpace(java.util.List<Space> value) { this.Space = value; }
}