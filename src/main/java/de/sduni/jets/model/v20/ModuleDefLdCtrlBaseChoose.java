package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleDefLdCtrlBaseChoose extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "ParamRefId")
    private String ParamRefId;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "When")
    private java.util.List<ModuleDefLdCtrlBaseChoose_when> When = new java.util.ArrayList<>();

    public String getParamRefId() { return ParamRefId; }
    public void setParamRefId(String value) { this.ParamRefId = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public java.util.List<ModuleDefLdCtrlBaseChoose_when> getWhen() { return When; }
    public void setWhen(java.util.List<ModuleDefLdCtrlBaseChoose_when> value) { this.When = value; }
}