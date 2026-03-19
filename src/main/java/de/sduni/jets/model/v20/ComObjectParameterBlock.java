package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComObjectParameterBlock extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Text")
    private String Text;
    @JacksonXmlProperty(isAttribute = true, localName = "Access")
    private String Access;
    @JacksonXmlProperty(isAttribute = true, localName = "HelpTopic")
    private long HelpTopic;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "ParamRefId")
    private String ParamRefId;
    @JacksonXmlProperty(isAttribute = true, localName = "TextParameterRefId")
    private String TextParameterRefId;
    @JacksonXmlProperty(isAttribute = true, localName = "Inline")
    private boolean Inline;
    @JacksonXmlProperty(isAttribute = true, localName = "Layout")
    private String Layout;
    @JacksonXmlProperty(isAttribute = true, localName = "Cell")
    private String Cell;
    @JacksonXmlProperty(isAttribute = true, localName = "Icon")
    private String Icon;
    @JacksonXmlProperty(isAttribute = true, localName = "HelpContext")
    private String HelpContext;
    @JacksonXmlProperty(isAttribute = true, localName = "ShowInComObjectTree")
    private boolean ShowInComObjectTree;
    @JacksonXmlProperty(isAttribute = true, localName = "Semantics")
    private String Semantics;
    @JacksonXmlProperty(localName = "Rows")
    private ComObjectParameterBlock_Rows Rows = null;
    @JacksonXmlProperty(localName = "Columns")
    private ComObjectParameterBlock_Columns Columns = null;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getText() { return Text; }
    public void setText(String value) { this.Text = value; }
    public String getAccess() { return Access; }
    public void setAccess(String value) { this.Access = value; }
    public long getHelpTopic() { return HelpTopic; }
    public void setHelpTopic(long value) { this.HelpTopic = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public String getParamRefId() { return ParamRefId; }
    public void setParamRefId(String value) { this.ParamRefId = value; }
    public String getTextParameterRefId() { return TextParameterRefId; }
    public void setTextParameterRefId(String value) { this.TextParameterRefId = value; }
    public boolean getInline() { return Inline; }
    public void setInline(boolean value) { this.Inline = value; }
    public String getLayout() { return Layout; }
    public void setLayout(String value) { this.Layout = value; }
    public String getCell() { return Cell; }
    public void setCell(String value) { this.Cell = value; }
    public String getIcon() { return Icon; }
    public void setIcon(String value) { this.Icon = value; }
    public String getHelpContext() { return HelpContext; }
    public void setHelpContext(String value) { this.HelpContext = value; }
    public boolean getShowInComObjectTree() { return ShowInComObjectTree; }
    public void setShowInComObjectTree(boolean value) { this.ShowInComObjectTree = value; }
    public String getSemantics() { return Semantics; }
    public void setSemantics(String value) { this.Semantics = value; }
    public ComObjectParameterBlock_Rows getRows() { return Rows; }
    public void setRows(ComObjectParameterBlock_Rows value) { this.Rows = value; }
    public ComObjectParameterBlock_Columns getColumns() { return Columns; }
    public void setColumns(ComObjectParameterBlock_Columns value) { this.Columns = value; }
}