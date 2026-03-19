package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LanguageData extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Identifier")
    private String Identifier;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "TranslationUnit")
    private java.util.List<LanguageData_TranslationUnit> TranslationUnit = new java.util.ArrayList<>();

    public String getIdentifier() { return Identifier; }
    public void setIdentifier(String value) { this.Identifier = value; }
    public java.util.List<LanguageData_TranslationUnit> getTranslationUnit() { return TranslationUnit; }
    public void setTranslationUnit(java.util.List<LanguageData_TranslationUnit> value) { this.TranslationUnit = value; }
}