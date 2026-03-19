package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project_ProjectInformation extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "GroupAddressStyle")
    private String GroupAddressStyle;
    @JacksonXmlProperty(isAttribute = true, localName = "ProjectNumber")
    private String ProjectNumber;
    @JacksonXmlProperty(isAttribute = true, localName = "ContractNumber")
    private String ContractNumber;
    @JacksonXmlProperty(isAttribute = true, localName = "LastModified")
    private java.time.LocalDateTime LastModified;
    @JacksonXmlProperty(isAttribute = true, localName = "ProjectStart")
    private java.time.LocalDateTime ProjectStart;
    @JacksonXmlProperty(isAttribute = true, localName = "ProjectEnd")
    private java.time.LocalDateTime ProjectEnd;
    @JacksonXmlProperty(isAttribute = true, localName = "ProjectId")
    private int ProjectId;
    @JacksonXmlProperty(isAttribute = true, localName = "ProjectPassword")
    private String ProjectPassword;
    @JacksonXmlProperty(isAttribute = true, localName = "Comment")
    private String Comment;
    @JacksonXmlProperty(isAttribute = true, localName = "CompletionStatus")
    private String CompletionStatus;
    @JacksonXmlProperty(isAttribute = true, localName = "ProjectTracingLevel")
    private String ProjectTracingLevel;
    @JacksonXmlProperty(isAttribute = true, localName = "ProjectTracingPassword")
    private String ProjectTracingPassword;
    @JacksonXmlProperty(isAttribute = true, localName = "Hide16BitGroupsFromLegacyPlugins")
    private boolean Hide16BitGroupsFromLegacyPlugins;
    @JacksonXmlProperty(isAttribute = true, localName = "CodePage")
    private String CodePage;
    @JacksonXmlProperty(isAttribute = true, localName = "BusAccessLegacyMode")
    private boolean BusAccessLegacyMode;
    @JacksonXmlProperty(isAttribute = true, localName = "Guid")
    private String Guid;
    @JacksonXmlProperty(isAttribute = true, localName = "LastUsedPuid")
    private int LastUsedPuid;
    @JacksonXmlProperty(isAttribute = true, localName = "Security")
    private String Security;
    @JacksonXmlProperty(localName = "HistoryEntries")
    private Project_ProjectInformation_HistoryEntries HistoryEntries = null;
    @JacksonXmlProperty(localName = "ToDoItems")
    private Project_ProjectInformation_ToDoItems ToDoItems = null;
    @JacksonXmlProperty(localName = "ProjectTraces")
    private Project_ProjectInformation_ProjectTraces ProjectTraces = null;
    @JacksonXmlProperty(localName = "DeviceCertificates")
    private Project_ProjectInformation_DeviceCertificates DeviceCertificates = null;

    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getGroupAddressStyle() { return GroupAddressStyle; }
    public void setGroupAddressStyle(String value) { this.GroupAddressStyle = value; }
    public String getProjectNumber() { return ProjectNumber; }
    public void setProjectNumber(String value) { this.ProjectNumber = value; }
    public String getContractNumber() { return ContractNumber; }
    public void setContractNumber(String value) { this.ContractNumber = value; }
    public java.time.LocalDateTime getLastModified() { return LastModified; }
    public void setLastModified(java.time.LocalDateTime value) { this.LastModified = value; }
    public java.time.LocalDateTime getProjectStart() { return ProjectStart; }
    public void setProjectStart(java.time.LocalDateTime value) { this.ProjectStart = value; }
    public java.time.LocalDateTime getProjectEnd() { return ProjectEnd; }
    public void setProjectEnd(java.time.LocalDateTime value) { this.ProjectEnd = value; }
    public int getProjectId() { return ProjectId; }
    public void setProjectId(int value) { this.ProjectId = value; }
    public String getProjectPassword() { return ProjectPassword; }
    public void setProjectPassword(String value) { this.ProjectPassword = value; }
    public String getComment() { return Comment; }
    public void setComment(String value) { this.Comment = value; }
    public String getCompletionStatus() { return CompletionStatus; }
    public void setCompletionStatus(String value) { this.CompletionStatus = value; }
    public String getProjectTracingLevel() { return ProjectTracingLevel; }
    public void setProjectTracingLevel(String value) { this.ProjectTracingLevel = value; }
    public String getProjectTracingPassword() { return ProjectTracingPassword; }
    public void setProjectTracingPassword(String value) { this.ProjectTracingPassword = value; }
    public boolean getHide16BitGroupsFromLegacyPlugins() { return Hide16BitGroupsFromLegacyPlugins; }
    public void setHide16BitGroupsFromLegacyPlugins(boolean value) { this.Hide16BitGroupsFromLegacyPlugins = value; }
    public String getCodePage() { return CodePage; }
    public void setCodePage(String value) { this.CodePage = value; }
    public boolean getBusAccessLegacyMode() { return BusAccessLegacyMode; }
    public void setBusAccessLegacyMode(boolean value) { this.BusAccessLegacyMode = value; }
    public String getGuid() { return Guid; }
    public void setGuid(String value) { this.Guid = value; }
    public int getLastUsedPuid() { return LastUsedPuid; }
    public void setLastUsedPuid(int value) { this.LastUsedPuid = value; }
    public String getSecurity() { return Security; }
    public void setSecurity(String value) { this.Security = value; }
    public Project_ProjectInformation_HistoryEntries getHistoryEntries() { return HistoryEntries; }
    public void setHistoryEntries(Project_ProjectInformation_HistoryEntries value) { this.HistoryEntries = value; }
    public Project_ProjectInformation_ToDoItems getToDoItems() { return ToDoItems; }
    public void setToDoItems(Project_ProjectInformation_ToDoItems value) { this.ToDoItems = value; }
    public Project_ProjectInformation_ProjectTraces getProjectTraces() { return ProjectTraces; }
    public void setProjectTraces(Project_ProjectInformation_ProjectTraces value) { this.ProjectTraces = value; }
    public Project_ProjectInformation_DeviceCertificates getDeviceCertificates() { return DeviceCertificates; }
    public void setDeviceCertificates(Project_ProjectInformation_DeviceCertificates value) { this.DeviceCertificates = value; }
}