package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic_Parameters_Parameter extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "ParameterType")
    private String ParameterType;
    @JacksonXmlProperty(isAttribute = true, localName = "ParameterTypeParams")
    private String ParameterTypeParams;
    @JacksonXmlProperty(isAttribute = true, localName = "Text")
    private String Text;
    @JacksonXmlProperty(isAttribute = true, localName = "SuffixText")
    private String SuffixText;
    @JacksonXmlProperty(isAttribute = true, localName = "Access")
    private String Access;
    @JacksonXmlProperty(isAttribute = true, localName = "Value")
    private String Value;
    @JacksonXmlProperty(isAttribute = true, localName = "InitialValue")
    private String InitialValue;
    @JacksonXmlProperty(isAttribute = true, localName = "CustomerAdjustable")
    private boolean CustomerAdjustable;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "LegacyPatchAlways")
    private boolean LegacyPatchAlways;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getParameterType() { return ParameterType; }
    public void setParameterType(String value) { this.ParameterType = value; }
    public String getParameterTypeParams() { return ParameterTypeParams; }
    public void setParameterTypeParams(String value) { this.ParameterTypeParams = value; }
    public String getText() { return Text; }
    public void setText(String value) { this.Text = value; }
    public String getSuffixText() { return SuffixText; }
    public void setSuffixText(String value) { this.SuffixText = value; }
    public String getAccess() { return Access; }
    public void setAccess(String value) { this.Access = value; }
    public String getValue() { return Value; }
    public void setValue(String value) { this.Value = value; }
    public String getInitialValue() { return InitialValue; }
    public void setInitialValue(String value) { this.InitialValue = value; }
    public boolean getCustomerAdjustable() { return CustomerAdjustable; }
    public void setCustomerAdjustable(boolean value) { this.CustomerAdjustable = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public boolean getLegacyPatchAlways() { return LegacyPatchAlways; }
    public void setLegacyPatchAlways(boolean value) { this.LegacyPatchAlways = value; }
}