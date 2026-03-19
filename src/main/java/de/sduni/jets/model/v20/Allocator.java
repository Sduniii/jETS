package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Allocator extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Id")
    private String Id;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "InternalDescription")
    private String InternalDescription;
    @JacksonXmlProperty(isAttribute = true, localName = "Start")
    private long Start;
    @JacksonXmlProperty(isAttribute = true, localName = "maxInclusive")
    private long maxInclusive;
    @JacksonXmlProperty(isAttribute = true, localName = "ErrorMessageRef")
    private String ErrorMessageRef;

    public String getId() { return Id; }
    public void setId(String value) { this.Id = value; }
    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getInternalDescription() { return InternalDescription; }
    public void setInternalDescription(String value) { this.InternalDescription = value; }
    public long getStart() { return Start; }
    public void setStart(long value) { this.Start = value; }
    public long getmaxInclusive() { return maxInclusive; }
    public void setmaxInclusive(long value) { this.maxInclusive = value; }
    public String getErrorMessageRef() { return ErrorMessageRef; }
    public void setErrorMessageRef(String value) { this.ErrorMessageRef = value; }
}