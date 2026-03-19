package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MaskVersion_MaskEntries extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "MaskEntry")
    private java.util.List<MaskVersion_MaskEntries_MaskEntry> MaskEntry = new java.util.ArrayList<>();

    public java.util.List<MaskVersion_MaskEntries_MaskEntry> getMaskEntry() { return MaskEntry; }
    public void setMaskEntry(java.util.List<MaskVersion_MaskEntries_MaskEntry> value) { this.MaskEntry = value; }
}