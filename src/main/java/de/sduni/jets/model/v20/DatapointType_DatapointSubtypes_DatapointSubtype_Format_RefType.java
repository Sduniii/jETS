package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatapointType_DatapointSubtypes_DatapointSubtype_Format_RefType extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "RefId")
    private String RefId;

    public String getRefId() { return RefId; }
    public void setRefId(String value) { this.RefId = value; }
}