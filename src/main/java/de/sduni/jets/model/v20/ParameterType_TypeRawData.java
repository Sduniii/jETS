package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterType_TypeRawData extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "MaxSize")
    private long MaxSize;

    public long getMaxSize() { return MaxSize; }
    public void setMaxSize(long value) { this.MaxSize = value; }
}