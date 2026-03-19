package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic_Code extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "AbsoluteSegment")
    private java.util.List<ApplicationProgramStatic_Code_AbsoluteSegment> AbsoluteSegment = new java.util.ArrayList<>();
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "RelativeSegment")
    private java.util.List<ApplicationProgramStatic_Code_RelativeSegment> RelativeSegment = new java.util.ArrayList<>();

    public java.util.List<ApplicationProgramStatic_Code_AbsoluteSegment> getAbsoluteSegment() { return AbsoluteSegment; }
    public void setAbsoluteSegment(java.util.List<ApplicationProgramStatic_Code_AbsoluteSegment> value) { this.AbsoluteSegment = value; }
    public java.util.List<ApplicationProgramStatic_Code_RelativeSegment> getRelativeSegment() { return RelativeSegment; }
    public void setRelativeSegment(java.util.List<ApplicationProgramStatic_Code_RelativeSegment> value) { this.RelativeSegment = value; }
}