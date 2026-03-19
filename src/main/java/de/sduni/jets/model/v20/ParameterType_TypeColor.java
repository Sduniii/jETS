package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterType_TypeColor extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Space")
    private String Space;

    public String getSpace() { return Space; }
    public void setSpace(String value) { this.Space = value; }
}