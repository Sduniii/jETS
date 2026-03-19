package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BusInterface_Connectors extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Connector")
    private java.util.List<BusInterface_Connectors_Connector> Connector = new java.util.ArrayList<>();

    public java.util.List<BusInterface_Connectors_Connector> getConnector() { return Connector; }
    public void setConnector(java.util.List<BusInterface_Connectors_Connector> value) { this.Connector = value; }
}