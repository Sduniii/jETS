package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatapointType_DatapointSubtypes_DatapointSubtype_Format_Reserved extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Width")
    private int Width;

    public int getWidth() { return Width; }
    public void setWidth(int value) { this.Width = value; }
}