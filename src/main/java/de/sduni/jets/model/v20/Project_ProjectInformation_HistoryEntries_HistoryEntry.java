package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project_ProjectInformation_HistoryEntries_HistoryEntry extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Date")
    private java.time.LocalDateTime Date;
    @JacksonXmlProperty(isAttribute = true, localName = "User")
    private String User;
    @JacksonXmlProperty(isAttribute = true, localName = "Text")
    private String Text;
    @JacksonXmlProperty(isAttribute = true, localName = "Detail")
    private String Detail;

    public java.time.LocalDateTime getDate() { return Date; }
    public void setDate(java.time.LocalDateTime value) { this.Date = value; }
    public String getUser() { return User; }
    public void setUser(String value) { this.User = value; }
    public String getText() { return Text; }
    public void setText(String value) { this.Text = value; }
    public String getDetail() { return Detail; }
    public void setDetail(String value) { this.Detail = value; }
}