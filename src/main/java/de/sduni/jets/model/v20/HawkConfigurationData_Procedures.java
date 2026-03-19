package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HawkConfigurationData_Procedures extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Procedure")
    private java.util.List<HawkConfigurationData_Procedures_Procedure> Procedure = new java.util.ArrayList<>();

    public java.util.List<HawkConfigurationData_Procedures_Procedure> getProcedure() { return Procedure; }
    public void setProcedure(java.util.List<HawkConfigurationData_Procedures_Procedure> value) { this.Procedure = value; }
}