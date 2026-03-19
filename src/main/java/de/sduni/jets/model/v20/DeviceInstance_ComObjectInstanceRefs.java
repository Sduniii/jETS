package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceInstance_ComObjectInstanceRefs extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ComObjectInstanceRef")
    private java.util.List<ComObjectInstanceRef> ComObjectInstanceRef = new java.util.ArrayList<>();

    public java.util.List<ComObjectInstanceRef> getComObjectInstanceRef() { return ComObjectInstanceRef; }
    public void setComObjectInstanceRef(java.util.List<ComObjectInstanceRef> value) { this.ComObjectInstanceRef = value; }
}