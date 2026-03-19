package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddinData extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "AddinId")
    private String AddinId;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;

    public String getAddinId() { return AddinId; }
    public void setAddinId(String value) { this.AddinId = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
}