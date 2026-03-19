package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LanguageData_TranslationUnit extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "RefId")
    private String RefId;
    @JacksonXmlProperty(isAttribute = true, localName = "Version")
    private int Version;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "TranslationElement")
    private java.util.List<LanguageData_TranslationUnit_TranslationElement> TranslationElement = new java.util.ArrayList<>();

    public String getRefId() { return RefId; }
    public void setRefId(String value) { this.RefId = value; }
    public int getVersion() { return Version; }
    public void setVersion(int value) { this.Version = value; }
    public java.util.List<LanguageData_TranslationUnit_TranslationElement> getTranslationElement() { return TranslationElement; }
    public void setTranslationElement(java.util.List<LanguageData_TranslationUnit_TranslationElement> value) { this.TranslationElement = value; }
}