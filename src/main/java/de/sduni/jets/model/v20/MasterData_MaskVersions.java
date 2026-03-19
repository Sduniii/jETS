package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData_MaskVersions extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "MaskVersion")
    private java.util.List<MaskVersion> MaskVersion = new java.util.ArrayList<>();

    public java.util.List<MaskVersion> getMaskVersion() { return MaskVersion; }
    public void setMaskVersion(java.util.List<MaskVersion> value) { this.MaskVersion = value; }
}