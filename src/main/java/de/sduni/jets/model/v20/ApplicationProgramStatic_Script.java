package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic_Script extends KnxBase {
    @JacksonXmlText
    private String content;

    public String getContent() { return content; }
    public void setContent(String value) { this.content = value; }
}
