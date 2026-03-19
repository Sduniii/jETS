package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BusInterface extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "RefId")
    private String RefId;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Description")
    private String Description;
    @JacksonXmlProperty(isAttribute = true, localName = "Comment")
    private String Comment;
    @JacksonXmlProperty(isAttribute = true, localName = "Password")
    private String Password;
    @JacksonXmlProperty(isAttribute = true, localName = "PasswordHash")
    private byte[] PasswordHash;
    @JacksonXmlProperty(localName = "Connectors")
    private BusInterface_Connectors Connectors = null;

    public String getRefId() { return RefId; }
    public void setRefId(String value) { this.RefId = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getDescription() { return Description; }
    public void setDescription(String value) { this.Description = value; }
    public String getComment() { return Comment; }
    public void setComment(String value) { this.Comment = value; }
    public String getPassword() { return Password; }
    public void setPassword(String value) { this.Password = value; }
    public byte[] getPasswordHash() { return PasswordHash; }
    public void setPasswordHash(byte[] value) { this.PasswordHash = value; }
    public BusInterface_Connectors getConnectors() { return Connectors; }
    public void setConnectors(BusInterface_Connectors value) { this.Connectors = value; }
}