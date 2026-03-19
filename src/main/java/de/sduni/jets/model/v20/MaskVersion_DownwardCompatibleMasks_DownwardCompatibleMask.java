package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MaskVersion_DownwardCompatibleMasks_DownwardCompatibleMask extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "RefId")
    private String RefId;

    public String getRefId() { return RefId; }
    public void setRefId(String value) { this.RefId = value; }
}