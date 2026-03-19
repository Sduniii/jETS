package de.sduni.jets.model.secure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "Keyring", namespace = "http://knx.org/xml/keyring/1")
@JsonIgnoreProperties(ignoreUnknown = true)
public class KnxKeyring {

    @JacksonXmlProperty(isAttribute = true, localName = "Project")
    private String project;

    @JacksonXmlProperty(isAttribute = true, localName = "Created")
    private String created;

    @JacksonXmlProperty(localName = "Interface")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Interface> interfaces;

    @JacksonXmlProperty(localName = "Devices")
    private DevicesContainer devices;

    public String getCreated() { return created; }
    public void setCreated(String created) { this.created = created; }

    public List<Interface> getInterfaces() { return interfaces; }
    public void setInterfaces(List<Interface> interfaces) { this.interfaces = interfaces; }

    public DevicesContainer getDevices() { return devices; }
    public void setDevices(DevicesContainer devices) { this.devices = devices; }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Interface {
        @JacksonXmlProperty(isAttribute = true, localName = "IndividualAddress")
        public String address;
        @JacksonXmlProperty(isAttribute = true, localName = "Host")
        public String host;
        @JacksonXmlProperty(isAttribute = true, localName = "UserID")
        public int userId;
        
        @JacksonXmlProperty(isAttribute = true, localName = "Password")
        @JsonAlias({"password", "Password"})
        public String password;
        
        @JacksonXmlProperty(isAttribute = true, localName = "Authentication")
        @JsonAlias({"authentication", "Authentication"})
        public String authentication;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DevicesContainer {
        @JacksonXmlProperty(localName = "Device")
        @JacksonXmlElementWrapper(useWrapping = false)
        public List<Device> deviceList;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Device {
        @JacksonXmlProperty(isAttribute = true, localName = "IndividualAddress")
        public String address;
        
        @JacksonXmlProperty(isAttribute = true, localName = "FDSK")
        @JsonAlias({"fdsk", "FDSK"})
        public String fdsk;
        
        @JacksonXmlProperty(isAttribute = true, localName = "Authentication")
        @JsonAlias({"authentication", "Authentication", "ManagementPassword", "managementPassword"})
        public String authentication;
    }
}
