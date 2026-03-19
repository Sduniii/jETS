package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserFile extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Filename")
    private String Filename;
    @JacksonXmlProperty(isAttribute = true, localName = "Comment")
    private String Comment;

    public String getFilename() { return Filename; }
    public void setFilename(String value) { this.Filename = value; }
    public String getComment() { return Comment; }
    public void setComment(String value) { this.Comment = value; }
}