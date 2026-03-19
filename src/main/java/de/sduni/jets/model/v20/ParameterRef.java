package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterRef extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "RefId")
    private String RefId;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Text")
    private String Text;
    @JacksonXmlProperty(isAttribute = true, localName = "SuffixText")
    private String SuffixText;
    @JacksonXmlProperty(isAttribute = true, localName = "Tag")
    private String Tag;
    @JacksonXmlProperty(isAttribute = true, localName = "DisplayOrder")
    private int DisplayOrder;
    @JacksonXmlProperty(isAttribute = true, localName = "Access")
    private String Access;
    @JacksonXmlProperty(isAttribute = true, localName = "Value")
    private String Value;
    @JacksonXmlProperty(isAttribute = true, localName = "InitialValue")
    private String InitialValue;
    @JacksonXmlProperty(isAttribute = true, localName = "CustomerAdjustable")
    private boolean CustomerAdjustable;
    @JacksonXmlProperty(isAttribute = true, localName = "TextParameterRefId")
    private String TextParameterRefId;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "ForbidGrantingUseByCustomer")
    private boolean ForbidGrantingUseByCustomer;
    @JacksonXmlProperty(isAttribute = true, localName = "Semantics")
    private String Semantics;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getRefId() { return RefId; }
    public void setRefId(String value) { this.RefId = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getText() { return Text; }
    public void setText(String value) { this.Text = value; }
    public String getSuffixText() { return SuffixText; }
    public void setSuffixText(String value) { this.SuffixText = value; }
    public String getTag() { return Tag; }
    public void setTag(String value) { this.Tag = value; }
    public int getDisplayOrder() { return DisplayOrder; }
    public void setDisplayOrder(int value) { this.DisplayOrder = value; }
    public String getAccess() { return Access; }
    public void setAccess(String value) { this.Access = value; }
    public String getValue() { return Value; }
    public void setValue(String value) { this.Value = value; }
    public String getInitialValue() { return InitialValue; }
    public void setInitialValue(String value) { this.InitialValue = value; }
    public boolean getCustomerAdjustable() { return CustomerAdjustable; }
    public void setCustomerAdjustable(boolean value) { this.CustomerAdjustable = value; }
    public String getTextParameterRefId() { return TextParameterRefId; }
    public void setTextParameterRefId(String value) { this.TextParameterRefId = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public boolean getForbidGrantingUseByCustomer() { return ForbidGrantingUseByCustomer; }
    public void setForbidGrantingUseByCustomer(boolean value) { this.ForbidGrantingUseByCustomer = value; }
    public String getSemantics() { return Semantics; }
    public void setSemantics(String value) { this.Semantics = value; }
}