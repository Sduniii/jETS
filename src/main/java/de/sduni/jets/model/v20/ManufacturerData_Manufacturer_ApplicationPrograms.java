package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ManufacturerData_Manufacturer_ApplicationPrograms extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ApplicationProgram")
    private java.util.List<ApplicationProgram> ApplicationProgram = new java.util.ArrayList<>();

    public java.util.List<ApplicationProgram> getApplicationProgram() { return ApplicationProgram; }
    public void setApplicationProgram(java.util.List<ApplicationProgram> value) { this.ApplicationProgram = value; }
}