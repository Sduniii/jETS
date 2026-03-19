package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceInstance_AdditionalAddresses_Address extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Address")
    private short Address;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Description")
    private String Description;
    @JacksonXmlProperty(isAttribute = true, localName = "Comment")
    private String Comment;

    public short getAddress() { return Address; }
    public void setAddress(short value) { this.Address = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getDescription() { return Description; }
    public void setDescription(String value) { this.Description = value; }
    public String getComment() { return Comment; }
    public void setComment(String value) { this.Comment = value; }
}