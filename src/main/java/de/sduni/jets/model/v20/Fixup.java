package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fixup extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "FunctionRef")
    private String FunctionRef;
    @JacksonXmlProperty(isAttribute = true, localName = "CodeSegment")
    private String CodeSegment;

    public String getFunctionRef() { return FunctionRef; }
    public void setFunctionRef(String value) { this.FunctionRef = value; }
    public String getCodeSegment() { return CodeSegment; }
    public void setCodeSegment(String value) { this.CodeSegment = value; }
}