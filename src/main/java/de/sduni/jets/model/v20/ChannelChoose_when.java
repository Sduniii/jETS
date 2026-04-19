package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelChoose_when extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Test")
    private String Test;
    @JacksonXmlProperty(isAttribute = true, localName = "Default")
    private boolean Default;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ParameterRefRef")
    private List<ParameterRefRef> ParameterRefRef = new ArrayList<>();

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ParameterBlock")
    private List<ComObjectParameterBlock> ParameterBlock = new ArrayList<>();

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "choose")
    private List<ChannelChoose> choose = new ArrayList<>();

    public String getTest() { return Test; }
    public void setTest(String value) { this.Test = value; }
    public boolean getDefault() { return Default; }
    public void setDefault(boolean value) { this.Default = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }

    public List<ParameterRefRef> getParameterRefRef() { return ParameterRefRef; }
    public void setParameterRefRef(List<ParameterRefRef> value) { this.ParameterRefRef = value; }
    public List<ComObjectParameterBlock> getParameterBlock() { return ParameterBlock; }
    public void setParameterBlock(List<ComObjectParameterBlock> value) { this.ParameterBlock = value; }
    public List<ChannelChoose> getChoose() { return choose; }
    public void setChoose(List<ChannelChoose> value) { this.choose = value; }
}
