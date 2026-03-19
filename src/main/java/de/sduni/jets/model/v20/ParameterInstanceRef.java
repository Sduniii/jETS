package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterInstanceRef extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "RefId")
    private String RefId;
    @JacksonXmlProperty(isAttribute = true, localName = "Value")
    private String Value;
    @JacksonXmlProperty(isAttribute = true, localName = "GrantUseByCustomer")
    private boolean GrantUseByCustomer;
    @JacksonXmlProperty(isAttribute = true, localName = "CustomizedText")
    private String CustomizedText;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getRefId() { return RefId; }
    public void setRefId(String value) { this.RefId = value; }
    public String getValue() { return Value; }
    public void setValue(String value) { this.Value = value; }
    public boolean getGrantUseByCustomer() { return GrantUseByCustomer; }
    public void setGrantUseByCustomer(boolean value) { this.GrantUseByCustomer = value; }
    public String getCustomizedText() { return CustomizedText; }
    public void setCustomizedText(String value) { this.CustomizedText = value; }
}