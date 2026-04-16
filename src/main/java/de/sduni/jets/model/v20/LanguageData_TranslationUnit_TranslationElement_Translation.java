package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LanguageData_TranslationUnit_TranslationElement_Translation extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "AttributeName")
    private String AttributeName;
    @JacksonXmlProperty(isAttribute = true, localName = "Value")
    private String Value;

    public String getAttributeName() { return AttributeName; }
    public void setAttributeName(String value) { this.AttributeName = value; }
    public String getValue() { return Value; }
    public void setValue(String value) { this.Value = value; }
}