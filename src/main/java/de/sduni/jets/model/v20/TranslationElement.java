package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TranslationElement extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "RefId")
    private String RefId;
    @JacksonXmlProperty(isAttribute = true, localName = "Text")
    private String Text;
    @JacksonXmlProperty(isAttribute = true, localName = "FunctionText")
    private String FunctionText;
    @JacksonXmlProperty(isAttribute = true, localName = "SuffixText")
    private String SuffixText;
    @JacksonXmlProperty(isAttribute = true, localName = "Description")
    private String Description;

    public String getRefId() { return RefId; }
    public void setRefId(String value) { this.RefId = value; }
    public String getText() { return Text; }
    public void setText(String value) { this.Text = value; }
    public String getFunctionText() { return FunctionText; }
    public void setFunctionText(String value) { this.FunctionText = value; }
    public String getSuffixText() { return SuffixText; }
    public void setSuffixText(String value) { this.SuffixText = value; }
    public String getDescription() { return Description; }
    public void setDescription(String value) { this.Description = value; }
}
