package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Language extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Identifier")
    private String Identifier;
    
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "TranslationElement")
    private java.util.List<TranslationElement> TranslationElement = new java.util.ArrayList<>();

    public String getIdentifier() { return Identifier; }
    public void setIdentifier(String value) { this.Identifier = value; }
    public java.util.List<TranslationElement> getTranslationElement() { return TranslationElement; }
    public void setTranslationElement(java.util.List<TranslationElement> value) { this.TranslationElement = value; }
}
