package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SplitInfos extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "SplitInfo")
    private java.util.List<SplitInfo> SplitInfo = new java.util.ArrayList<>();

    public java.util.List<SplitInfo> getSplitInfo() { return SplitInfo; }
    public void setSplitInfo(java.util.List<SplitInfo> value) { this.SplitInfo = value; }
}