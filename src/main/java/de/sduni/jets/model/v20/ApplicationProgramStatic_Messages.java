package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic_Messages extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Message")
    private java.util.List<ApplicationProgramStatic_Messages_Message> Message = new java.util.ArrayList<>();

    public java.util.List<ApplicationProgramStatic_Messages_Message> getMessage() { return Message; }
    public void setMessage(java.util.List<ApplicationProgramStatic_Messages_Message> value) { this.Message = value; }
}