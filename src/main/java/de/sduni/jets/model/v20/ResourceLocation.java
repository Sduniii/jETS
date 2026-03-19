package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceLocation extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "AddressSpace")
    private String AddressSpace;
    @JacksonXmlProperty(isAttribute = true, localName = "InterfaceObjectRef")
    private int InterfaceObjectRef;
    @JacksonXmlProperty(isAttribute = true, localName = "PropertyID")
    private int PropertyID;
    @JacksonXmlProperty(isAttribute = true, localName = "StartAddress")
    private long StartAddress;
    @JacksonXmlProperty(isAttribute = true, localName = "Occurrence")
    private int Occurrence;
    @JacksonXmlProperty(isAttribute = true, localName = "PtrResource")
    private String PtrResource;

    public String getAddressSpace() { return AddressSpace; }
    public void setAddressSpace(String value) { this.AddressSpace = value; }
    public int getInterfaceObjectRef() { return InterfaceObjectRef; }
    public void setInterfaceObjectRef(int value) { this.InterfaceObjectRef = value; }
    public int getPropertyID() { return PropertyID; }
    public void setPropertyID(int value) { this.PropertyID = value; }
    public long getStartAddress() { return StartAddress; }
    public void setStartAddress(long value) { this.StartAddress = value; }
    public int getOccurrence() { return Occurrence; }
    public void setOccurrence(int value) { this.Occurrence = value; }
    public String getPtrResource() { return PtrResource; }
    public void setPtrResource(String value) { this.PtrResource = value; }
}