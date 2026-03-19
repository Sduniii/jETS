package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleDefStatic_ComObjects_ComObject extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Text")
    private String Text;
    @JacksonXmlProperty(isAttribute = true, localName = "Number")
    private long Number;
    @JacksonXmlProperty(isAttribute = true, localName = "FunctionText")
    private String FunctionText;
    @JacksonXmlProperty(isAttribute = true, localName = "Priority")
    private String Priority;
    @JacksonXmlProperty(isAttribute = true, localName = "ObjectSize")
    private String ObjectSize;
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
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "SecurityRequired")
    private String SecurityRequired;
    @JacksonXmlProperty(isAttribute = true, localName = "MayRead")
    private boolean MayRead;
    @JacksonXmlProperty(isAttribute = true, localName = "ReadFlagLocked")
    private boolean ReadFlagLocked;
    @JacksonXmlProperty(isAttribute = true, localName = "WriteFlagLocked")
    private boolean WriteFlagLocked;
    @JacksonXmlProperty(isAttribute = true, localName = "TransmitFlagLocked")
    private boolean TransmitFlagLocked;
    @JacksonXmlProperty(isAttribute = true, localName = "UpdateFlagLocked")
    private boolean UpdateFlagLocked;
    @JacksonXmlProperty(isAttribute = true, localName = "ReadOnInitFlagLocked")
    private boolean ReadOnInitFlagLocked;
    @JacksonXmlProperty(isAttribute = true, localName = "BaseNumber")
    private String BaseNumber;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getText() { return Text; }
    public void setText(String value) { this.Text = value; }
    public long getNumber() { return Number; }
    public void setNumber(long value) { this.Number = value; }
    public String getFunctionText() { return FunctionText; }
    public void setFunctionText(String value) { this.FunctionText = value; }
    public String getPriority() { return Priority; }
    public void setPriority(String value) { this.Priority = value; }
    public String getObjectSize() { return ObjectSize; }
    public void setObjectSize(String value) { this.ObjectSize = value; }
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
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public String getSecurityRequired() { return SecurityRequired; }
    public void setSecurityRequired(String value) { this.SecurityRequired = value; }
    public boolean getMayRead() { return MayRead; }
    public void setMayRead(boolean value) { this.MayRead = value; }
    public boolean getReadFlagLocked() { return ReadFlagLocked; }
    public void setReadFlagLocked(boolean value) { this.ReadFlagLocked = value; }
    public boolean getWriteFlagLocked() { return WriteFlagLocked; }
    public void setWriteFlagLocked(boolean value) { this.WriteFlagLocked = value; }
    public boolean getTransmitFlagLocked() { return TransmitFlagLocked; }
    public void setTransmitFlagLocked(boolean value) { this.TransmitFlagLocked = value; }
    public boolean getUpdateFlagLocked() { return UpdateFlagLocked; }
    public void setUpdateFlagLocked(boolean value) { this.UpdateFlagLocked = value; }
    public boolean getReadOnInitFlagLocked() { return ReadOnInitFlagLocked; }
    public void setReadOnInitFlagLocked(boolean value) { this.ReadOnInitFlagLocked = value; }
    public String getBaseNumber() { return BaseNumber; }
    public void setBaseNumber(String value) { this.BaseNumber = value; }
}