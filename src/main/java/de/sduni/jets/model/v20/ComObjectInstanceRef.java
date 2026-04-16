package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComObjectInstanceRef extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "RefId")
    private String RefId;
    @JacksonXmlProperty(isAttribute = true, localName = "Text")
    private String Text;
    @JacksonXmlProperty(isAttribute = true, localName = "FunctionText")
    private String FunctionText;
    @JacksonXmlProperty(isAttribute = true, localName = "Priority")
    private String Priority;
    @JacksonXmlProperty(isAttribute = true, localName = "ReadFlag")
    private String ReadFlag;
    @JacksonXmlProperty(isAttribute = true, localName = "WriteFlag")
    private String WriteFlag;
    @JacksonXmlProperty(isAttribute = true, localName = "CommunicationFlag")
    private String CommunicationFlag;
    @JacksonXmlProperty(isAttribute = true, localName = "TransmitFlag")
    private String TransmitFlag;
    @JacksonXmlProperty(isAttribute = true, localName = "UpdateFlag")
    private String UpdateFlag;
    @JacksonXmlProperty(isAttribute = true, localName = "ReadOnInitFlag")
    private String ReadOnInitFlag;
    @JacksonXmlProperty(isAttribute = true, localName = "DatapointType")
    private String DatapointType;
    @JacksonXmlProperty(isAttribute = true, localName = "Description")
    private String Description;
    @JacksonXmlProperty(isAttribute = true, localName = "ChannelId")
    private String ChannelId;
    @JacksonXmlProperty(isAttribute = true, localName = "Links")
    private String Links;
    @JacksonXmlProperty(isAttribute = true, localName = "Acknowledges")
    private String Acknowledges;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Connect")
    private List<ComObjectInstanceRef_Connect> Connect = new ArrayList<>();

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getRefId() { return RefId; }
    public void setRefId(String value) { this.RefId = value; }
    public String getText() { return Text; }
    public void setText(String value) { this.Text = value; }
    public String getFunctionText() { return FunctionText; }
    public void setFunctionText(String value) { this.FunctionText = value; }
    public String getPriority() { return Priority; }
    public void setPriority(String value) { this.Priority = value; }
    public String getReadFlag() { return ReadFlag; }
    public void setReadFlag(String value) { this.ReadFlag = value; }
    public String getWriteFlag() { return WriteFlag; }
    public void setWriteFlag(String value) { this.WriteFlag = value; }
    public String getCommunicationFlag() { return CommunicationFlag; }
    public void setCommunicationFlag(String value) { this.CommunicationFlag = value; }
    public String getTransmitFlag() { return TransmitFlag; }
    public void setTransmitFlag(String value) { this.TransmitFlag = value; }
    public String getUpdateFlag() { return UpdateFlag; }
    public void setUpdateFlag(String value) { this.UpdateFlag = value; }
    public String getReadOnInitFlag() { return ReadOnInitFlag; }
    public void setReadOnInitFlag(String value) { this.ReadOnInitFlag = value; }
    public String getDatapointType() { return DatapointType; }
    public void setDatapointType(String value) { this.DatapointType = value; }
    public String getDescription() { return Description; }
    public void setDescription(String value) { this.Description = value; }
    public String getChannelId() { return ChannelId; }
    public void setChannelId(String value) { this.ChannelId = value; }
    public String getLinks() { return Links; }
    public void setLinks(String value) { this.Links = value; }
    public String getAcknowledges() { return Acknowledges; }
    public void setAcknowledges(String value) { this.Acknowledges = value; }
    public List<ComObjectInstanceRef_Connect> getConnect() { return Connect; }
    public void setConnect(List<ComObjectInstanceRef_Connect> value) { this.Connect = value; }
}