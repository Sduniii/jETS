package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class P2PLinks extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "P2PLink")
    private java.util.List<P2PLinks_P2PLink> P2PLink = new java.util.ArrayList<>();

    public java.util.List<P2PLinks_P2PLink> getP2PLink() { return P2PLink; }
    public void setP2PLink(java.util.List<P2PLinks_P2PLink> value) { this.P2PLink = value; }
}