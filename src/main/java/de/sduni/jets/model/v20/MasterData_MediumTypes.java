package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData_MediumTypes extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "MediumType")
    private java.util.List<MasterData_MediumTypes_MediumType> MediumType = new java.util.ArrayList<>();

    public java.util.List<MasterData_MediumTypes_MediumType> getMediumType() { return MediumType; }
    public void setMediumType(java.util.List<MasterData_MediumTypes_MediumType> value) { this.MediumType = value; }
}