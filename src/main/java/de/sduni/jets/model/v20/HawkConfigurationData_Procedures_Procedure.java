package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HawkConfigurationData_Procedures_Procedure extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "ProcedureType")
    private String ProcedureType;
    @JacksonXmlProperty(isAttribute = true, localName = "ProcedureSubType")
    private String ProcedureSubType;
    @JacksonXmlProperty(isAttribute = true, localName = "Access")
    private String Access;

    public String getProcedureType() { return ProcedureType; }
    public void setProcedureType(String value) { this.ProcedureType = value; }
    public String getProcedureSubType() { return ProcedureSubType; }
    public void setProcedureSubType(String value) { this.ProcedureSubType = value; }
    public String getAccess() { return Access; }
    public void setAccess(String value) { this.Access = value; }
}