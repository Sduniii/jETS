package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceInstance_BinaryData_BinaryData extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "RefId")
    private String RefId;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "AutoCopy")
    private boolean AutoCopy;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getRefId() { return RefId; }
    public void setRefId(String value) { this.RefId = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public boolean getAutoCopy() { return AutoCopy; }
    public void setAutoCopy(boolean value) { this.AutoCopy = value; }
}