package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SplitInfo extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "ObjectPath")
    private String ObjectPath;
    @JacksonXmlProperty(isAttribute = true, localName = "Cookie")
    private String Cookie;

    public String getObjectPath() { return ObjectPath; }
    public void setObjectPath(String value) { this.ObjectPath = value; }
    public String getCookie() { return Cookie; }
    public void setCookie(String value) { this.Cookie = value; }
}