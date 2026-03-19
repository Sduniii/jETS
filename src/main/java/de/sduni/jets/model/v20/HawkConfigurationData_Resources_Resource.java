package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HawkConfigurationData_Resources_Resource extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String Name;
    @JacksonXmlProperty(isAttribute = true, localName = "Access")
    private String Access;
    @JacksonXmlProperty(isAttribute = true, localName = "MgmtStyle")
    private String MgmtStyle;
    @JacksonXmlProperty(localName = "Location")
    private ResourceLocation Location = null;
    @JacksonXmlProperty(localName = "ImgLocation")
    private ResourceLocation ImgLocation = null;
    @JacksonXmlProperty(localName = "ResourceType")
    private HawkConfigurationData_Resources_Resource_ResourceType ResourceType = null;
    @JacksonXmlProperty(localName = "AccessRights")
    private HawkConfigurationData_Resources_Resource_AccessRights AccessRights = null;

    public String getName() { return Name; }
    public void setName(String value) { this.Name = value; }
    public String getAccess() { return Access; }
    public void setAccess(String value) { this.Access = value; }
    public String getMgmtStyle() { return MgmtStyle; }
    public void setMgmtStyle(String value) { this.MgmtStyle = value; }
    public ResourceLocation getLocation() { return Location; }
    public void setLocation(ResourceLocation value) { this.Location = value; }
    public ResourceLocation getImgLocation() { return ImgLocation; }
    public void setImgLocation(ResourceLocation value) { this.ImgLocation = value; }
    public HawkConfigurationData_Resources_Resource_ResourceType getResourceType() { return ResourceType; }
    public void setResourceType(HawkConfigurationData_Resources_Resource_ResourceType value) { this.ResourceType = value; }
    public HawkConfigurationData_Resources_Resource_AccessRights getAccessRights() { return AccessRights; }
    public void setAccessRights(HawkConfigurationData_Resources_Resource_AccessRights value) { this.AccessRights = value; }
}