package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectTrace extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Date")
    private java.time.LocalDateTime Date;
    @JacksonXmlProperty(isAttribute = true, localName = "UserName")
    private String UserName;
    @JacksonXmlProperty(isAttribute = true, localName = "Comment")
    private String Comment;

    public java.time.LocalDateTime getDate() { return Date; }
    public void setDate(java.time.LocalDateTime value) { this.Date = value; }
    public String getUserName() { return UserName; }
    public void setUserName(String value) { this.UserName = value; }
    public String getComment() { return Comment; }
    public void setComment(String value) { this.Comment = value; }
}