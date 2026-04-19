package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramChannel extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Text")
    private String Text;
    @JacksonXmlProperty(isAttribute = true, localName = "Number")
    private String Number;
    @JacksonXmlProperty(isAttribute = true, localName = "TextParameterRefId")
    private String TextParameterRefId;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "Icon")
    private String Icon;
    @JacksonXmlProperty(isAttribute = true, localName = "HelpContext")
    private String HelpContext;
    @JacksonXmlProperty(isAttribute = true, localName = "Semantics")
    private String Semantics;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ParameterBlock")
    private List<ComObjectParameterBlock> ParameterBlock = new ArrayList<>();

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "choose")
    private List<ChannelChoose> choose = new ArrayList<>();

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getText() { return Text; }
    public void setText(String value) { this.Text = value; }
    public String getNumber() { return Number; }
    public void setNumber(String value) { this.Number = value; }
    public String getTextParameterRefId() { return TextParameterRefId; }
    public void setTextParameterRefId(String value) { this.TextParameterRefId = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public String getIcon() { return Icon; }
    public void setIcon(String value) { this.Icon = value; }
    public String getHelpContext() { return HelpContext; }
    public void setHelpContext(String value) { this.HelpContext = value; }
    public String getSemantics() { return Semantics; }
    public void setSemantics(String value) { this.Semantics = value; }
    public List<ComObjectParameterBlock> getParameterBlock() { return ParameterBlock; }
    public void setParameterBlock(List<ComObjectParameterBlock> value) { this.ParameterBlock = value; }
    public List<ChannelChoose> getChoose() { return choose; }
    public void setChoose(List<ChannelChoose> value) { this.choose = value; }
}
