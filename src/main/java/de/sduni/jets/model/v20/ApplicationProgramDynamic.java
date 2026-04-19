package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramDynamic extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Channel")
    private List<ApplicationProgramChannel> Channel = new ArrayList<>();

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ParameterBlock")
    private List<ComObjectParameterBlock> ParameterBlock = new ArrayList<>();

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "choose")
    private List<ChannelChoose> choose = new ArrayList<>();

    public List<ApplicationProgramChannel> getChannel() { return Channel; }
    public void setChannel(List<ApplicationProgramChannel> value) { this.Channel = value; }
    public List<ComObjectParameterBlock> getParameterBlock() { return ParameterBlock; }
    public void setParameterBlock(List<ComObjectParameterBlock> value) { this.ParameterBlock = value; }
    public List<ChannelChoose> getChoose() { return choose; }
    public void setChoose(List<ChannelChoose> value) { this.choose = value; }
}
