package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterValidation extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "ValidationFunc")
    private String ValidationFunc;
    @JacksonXmlProperty(isAttribute = true, localName = "ValidationParameters")
    private String ValidationParameters;
    @JacksonXmlProperty(localName = "Parameters")
    private ParameterValidation_Parameters Parameters = null;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public String getValidationFunc() { return ValidationFunc; }
    public void setValidationFunc(String value) { this.ValidationFunc = value; }
    public String getValidationParameters() { return ValidationParameters; }
    public void setValidationParameters(String value) { this.ValidationParameters = value; }
    public ParameterValidation_Parameters getParameters() { return Parameters; }
    public void setParameters(ParameterValidation_Parameters value) { this.Parameters = value; }
}