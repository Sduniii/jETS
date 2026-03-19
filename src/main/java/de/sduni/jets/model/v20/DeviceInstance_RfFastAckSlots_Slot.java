package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceInstance_RfFastAckSlots_Slot extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "GroupAddressRefId")
    private String GroupAddressRefId;
    @JacksonXmlProperty(isAttribute = true, localName = "Number")
    private short Number;

    public String getGroupAddressRefId() { return GroupAddressRefId; }
    public void setGroupAddressRefId(String value) { this.GroupAddressRefId = value; }
    public short getNumber() { return Number; }
    public void setNumber(short value) { this.Number = value; }
}