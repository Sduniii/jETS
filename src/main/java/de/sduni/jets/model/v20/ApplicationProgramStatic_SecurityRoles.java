package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic_SecurityRoles extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "SecurityRole")
    private java.util.List<ApplicationProgramStatic_SecurityRoles_SecurityRole> SecurityRole = new java.util.ArrayList<>();

    public java.util.List<ApplicationProgramStatic_SecurityRoles_SecurityRole> getSecurityRole() { return SecurityRole; }
    public void setSecurityRole(java.util.List<ApplicationProgramStatic_SecurityRoles_SecurityRole> value) { this.SecurityRole = value; }
}