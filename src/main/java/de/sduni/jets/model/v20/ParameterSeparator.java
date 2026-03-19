package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterSeparator extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Text")
    private String Text;
    @JacksonXmlProperty(isAttribute = true, localName = "Access")
    private String Access;
    @JacksonXmlProperty(isAttribute = true, localName = "UIHint")
    private String UIHint;
    @JacksonXmlProperty(isAttribute = true, localName = "TextParameterRefId")
    private String TextParameterRefId;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "Cell")
    private String Cell;
    @JacksonXmlProperty(isAttribute = true, localName = "Icon")
    private String Icon;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getText() { return Text; }
    public void setText(String value) { this.Text = value; }
    public String getAccess() { return Access; }
    public void setAccess(String value) { this.Access = value; }
    public String getUIHint() { return UIHint; }
    public void setUIHint(String value) { this.UIHint = value; }
    public String getTextParameterRefId() { return TextParameterRefId; }
    public void setTextParameterRefId(String value) { this.TextParameterRefId = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public String getCell() { return Cell; }
    public void setCell(String value) { this.Cell = value; }
    public String getIcon() { return Icon; }
    public void setIcon(String value) { this.Icon = value; }
}