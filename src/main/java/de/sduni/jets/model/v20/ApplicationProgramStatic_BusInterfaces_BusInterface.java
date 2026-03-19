package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic_BusInterfaces_BusInterface extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "AddressIndex")
    private short AddressIndex;
    @JacksonXmlProperty(isAttribute = true, localName = "AccessType")
    private String AccessType;
    @JacksonXmlProperty(isAttribute = true, localName = "Text")
    private String Text;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public short getAddressIndex() { return AddressIndex; }
    public void setAddressIndex(short value) { this.AddressIndex = value; }
    public String getAccessType() { return AccessType; }
    public void setAccessType(String value) { this.AccessType = value; }
    public String getText() { return Text; }
    public void setText(String value) { this.Text = value; }
}