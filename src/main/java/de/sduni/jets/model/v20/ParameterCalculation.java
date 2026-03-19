package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterCalculation extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Language")
    private String Language;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "RLTransformationFunc")
    private String RLTransformationFunc;
    @JacksonXmlProperty(isAttribute = true, localName = "RLTransformationParameters")
    private String RLTransformationParameters;
    @JacksonXmlProperty(isAttribute = true, localName = "LRTransformationFunc")
    private String LRTransformationFunc;
    @JacksonXmlProperty(isAttribute = true, localName = "LRTransformationParameters")
    private String LRTransformationParameters;
    @JacksonXmlProperty(localName = "LParameters")
    private ParameterCalculation_LParameters LParameters = null;
    @JacksonXmlProperty(localName = "RParameters")
    private ParameterCalculation_RParameters RParameters = null;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getLanguage() { return Language; }
    public void setLanguage(String value) { this.Language = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public String getRLTransformationFunc() { return RLTransformationFunc; }
    public void setRLTransformationFunc(String value) { this.RLTransformationFunc = value; }
    public String getRLTransformationParameters() { return RLTransformationParameters; }
    public void setRLTransformationParameters(String value) { this.RLTransformationParameters = value; }
    public String getLRTransformationFunc() { return LRTransformationFunc; }
    public void setLRTransformationFunc(String value) { this.LRTransformationFunc = value; }
    public String getLRTransformationParameters() { return LRTransformationParameters; }
    public void setLRTransformationParameters(String value) { this.LRTransformationParameters = value; }
    public ParameterCalculation_LParameters getLParameters() { return LParameters; }
    public void setLParameters(ParameterCalculation_LParameters value) { this.LParameters = value; }
    public ParameterCalculation_RParameters getRParameters() { return RParameters; }
    public void setRParameters(ParameterCalculation_RParameters value) { this.RParameters = value; }
}