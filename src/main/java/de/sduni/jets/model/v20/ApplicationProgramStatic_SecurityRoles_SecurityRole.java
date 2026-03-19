package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic_SecurityRoles_SecurityRole extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Text")
    private String Text;
    @JacksonXmlProperty(isAttribute = true, localName = "Mask")
    private int Mask;
    @JacksonXmlProperty(isAttribute = true, localName = "RoleID")
    private long RoleID;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getText() { return Text; }
    public void setText(String value) { this.Text = value; }
    public int getMask() { return Mask; }
    public void setMask(int value) { this.Mask = value; }
    public long getRoleID() { return RoleID; }
    public void setRoleID(long value) { this.RoleID = value; }
}