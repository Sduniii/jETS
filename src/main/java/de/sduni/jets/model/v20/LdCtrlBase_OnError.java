package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LdCtrlBase_OnError extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Cause")
    private String Cause;
    @JacksonXmlProperty(isAttribute = true, localName = "Ignore")
    private boolean Ignore;
    @JacksonXmlProperty(isAttribute = true, localName = "MessageRef")
    private String MessageRef;

    public String getCause() { return Cause; }
    public void setCause(String value) { this.Cause = value; }
    public boolean getIgnore() { return Ignore; }
    public void setIgnore(boolean value) { this.Ignore = value; }
    public String getMessageRef() { return MessageRef; }
    public void setMessageRef(String value) { this.MessageRef = value; }
}