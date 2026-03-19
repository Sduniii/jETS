package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HawkConfigurationData_MemorySegments_MemorySegment_AccessRights extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Read")
    private String Read;
    @JacksonXmlProperty(isAttribute = true, localName = "Write")
    private String Write;

    public String getRead() { return Read; }
    public void setRead(String value) { this.Read = value; }
    public String getWrite() { return Write; }
    public void setWrite(String value) { this.Write = value; }
}