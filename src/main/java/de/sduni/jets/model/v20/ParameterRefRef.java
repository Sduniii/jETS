package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterRefRef extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "RefId")
    private String RefId;
    @JacksonXmlProperty(isAttribute = true, localName = "HelpContext")
    private String HelpContext;
    @JacksonXmlProperty(isAttribute = true, localName = "IndentLevel")
    private byte IndentLevel;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "Cell")
    private String Cell;
    @JacksonXmlProperty(isAttribute = true, localName = "Icon")
    private String Icon;

    public String getRefId() { return RefId; }
    public void setRefId(String value) { this.RefId = value; }
    public String getHelpContext() { return HelpContext; }
    public void setHelpContext(String value) { this.HelpContext = value; }
    public byte getIndentLevel() { return IndentLevel; }
    public void setIndentLevel(byte value) { this.IndentLevel = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public String getCell() { return Cell; }
    public void setCell(String value) { this.Cell = value; }
    public String getIcon() { return Icon; }
    public void setIcon(String value) { this.Icon = value; }
}