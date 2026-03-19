package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData_ProductLanguages_Language extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Identifier")
    private String Identifier;

    public String getIdentifier() { return Identifier; }
    public void setIdentifier(String value) { this.Identifier = value; }
}