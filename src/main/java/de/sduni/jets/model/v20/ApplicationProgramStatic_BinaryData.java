package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic_BinaryData extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "BinaryData")
    private java.util.List<BinaryData> BinaryData = new java.util.ArrayList<>();

    public java.util.List<BinaryData> getBinaryData() { return BinaryData; }
    public void setBinaryData(java.util.List<BinaryData> value) { this.BinaryData = value; }
}