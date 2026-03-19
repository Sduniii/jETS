package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData_ProductLanguages extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Language")
    private java.util.List<MasterData_ProductLanguages_Language> Language = new java.util.ArrayList<>();

    public java.util.List<MasterData_ProductLanguages_Language> getLanguage() { return Language; }
    public void setLanguage(java.util.List<MasterData_ProductLanguages_Language> value) { this.Language = value; }
}