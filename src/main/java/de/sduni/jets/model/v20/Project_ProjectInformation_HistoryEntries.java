package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project_ProjectInformation_HistoryEntries extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "HistoryEntry")
    private java.util.List<Project_ProjectInformation_HistoryEntries_HistoryEntry> HistoryEntry = new java.util.ArrayList<>();

    public java.util.List<Project_ProjectInformation_HistoryEntries_HistoryEntry> getHistoryEntry() { return HistoryEntry; }
    public void setHistoryEntry(java.util.List<Project_ProjectInformation_HistoryEntries_HistoryEntry> value) { this.HistoryEntry = value; }
}