package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComObjectParameterBlock_Rows_Row extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Text")
    private String Text;
    @JacksonXmlProperty(isAttribute = true, localName = "TextParameterRefId")
    private String TextParameterRefId;
    @JacksonXmlProperty(isAttribute = true, localName = "CollapseIfEmpty")
    private boolean CollapseIfEmpty;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getText() { return Text; }
    public void setText(String value) { this.Text = value; }
    public String getTextParameterRefId() { return TextParameterRefId; }
    public void setTextParameterRefId(String value) { this.TextParameterRefId = value; }
    public boolean getCollapseIfEmpty() { return CollapseIfEmpty; }
    public void setCollapseIfEmpty(boolean value) { this.CollapseIfEmpty = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
}