package de.sduni.jets.model.v20;

import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComObjectInstanceRef_Connect extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "GroupAddressRefId")
    private String GroupAddressRefId;

    public String getGroupAddressRefId() { return GroupAddressRefId; }
    public void setGroupAddressRefId(String value) { this.GroupAddressRefId = value; }
}
