package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MaskVersion_DownwardCompatibleMasks extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "DownwardCompatibleMask")
    private java.util.List<MaskVersion_DownwardCompatibleMasks_DownwardCompatibleMask> DownwardCompatibleMask = new java.util.ArrayList<>();

    public java.util.List<MaskVersion_DownwardCompatibleMasks_DownwardCompatibleMask> getDownwardCompatibleMask() { return DownwardCompatibleMask; }
    public void setDownwardCompatibleMask(java.util.List<MaskVersion_DownwardCompatibleMasks_DownwardCompatibleMask> value) { this.DownwardCompatibleMask = value; }
}