package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterType extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "Plugin")
    private String Plugin;
    @JacksonXmlProperty(isAttribute = true, localName = "ValidationErrorRef")
    private String ValidationErrorRef;

    @JacksonXmlProperty(localName = "TypeNumber")
    private ParameterType_TypeNumber TypeNumber = null;
    @JacksonXmlProperty(localName = "TypeRestriction")
    private ParameterType_TypeRestriction TypeRestriction = null;
    @JacksonXmlProperty(localName = "TypeFloat")
    private ParameterType_TypeFloat TypeFloat = null;
    @JacksonXmlProperty(localName = "TypeText")
    private ParameterType_TypeText TypeText = null;
    @JacksonXmlProperty(localName = "TypeNone")
    private ParameterType_TypeNone TypeNone = null;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public String getPlugin() { return Plugin; }
    public void setPlugin(String value) { this.Plugin = value; }
    public String getValidationErrorRef() { return ValidationErrorRef; }
    public void setValidationErrorRef(String value) { this.ValidationErrorRef = value; }

    public ParameterType_TypeNumber getTypeNumber() { return TypeNumber; }
    public void setTypeNumber(ParameterType_TypeNumber value) { this.TypeNumber = value; }
    public ParameterType_TypeRestriction getTypeRestriction() { return TypeRestriction; }
    public void setTypeRestriction(ParameterType_TypeRestriction value) { this.TypeRestriction = value; }
    public ParameterType_TypeFloat getTypeFloat() { return TypeFloat; }
    public void setTypeFloat(ParameterType_TypeFloat value) { this.TypeFloat = value; }
    public ParameterType_TypeText getTypeText() { return TypeText; }
    public void setTypeText(ParameterType_TypeText value) { this.TypeText = value; }
    public ParameterType_TypeNone getTypeNone() { return TypeNone; }
    public void setTypeNone(ParameterType_TypeNone value) { this.TypeNone = value; }
}