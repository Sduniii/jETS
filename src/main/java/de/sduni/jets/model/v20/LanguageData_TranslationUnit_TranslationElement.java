package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LanguageData_TranslationUnit_TranslationElement extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "RefId")
    private String RefId;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Translation")
    private java.util.List<LanguageData_TranslationUnit_TranslationElement_Translation> Translation = new java.util.ArrayList<>();

    public String getRefId() { return RefId; }
    public void setRefId(String value) { this.RefId = value; }
    public java.util.List<LanguageData_TranslationUnit_TranslationElement_Translation> getTranslation() { return Translation; }
    public void setTranslation(java.util.List<LanguageData_TranslationUnit_TranslationElement_Translation> value) { this.Translation = value; }
}