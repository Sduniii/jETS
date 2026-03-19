package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BusAccess extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Edi")
    private String Edi;
    @JacksonXmlProperty(isAttribute = true, localName = "Parameter")
    private String Parameter;

    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getEdi() { return Edi; }
    public void setEdi(String value) { this.Edi = value; }
    public String getParameter() { return Parameter; }
    public void setParameter(String value) { this.Parameter = value; }
}