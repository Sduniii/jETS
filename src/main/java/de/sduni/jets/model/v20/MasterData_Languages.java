package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData_Languages extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Language")
    private java.util.List<LanguageData> Language = new java.util.ArrayList<>();

    public java.util.List<LanguageData> getLanguage() { return Language; }
    public void setLanguage(java.util.List<LanguageData> value) { this.Language = value; }
}