package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterType_TypePicture extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "RefId")
    private String RefId;
    @JacksonXmlProperty(isAttribute = true, localName = "HorizontalAlignment")
    private String HorizontalAlignment;

    public String getRefId() { return RefId; }
    public void setRefId(String value) { this.RefId = value; }
    public String getHorizontalAlignment() { return HorizontalAlignment; }
    public void setHorizontalAlignment(String value) { this.HorizontalAlignment = value; }
}