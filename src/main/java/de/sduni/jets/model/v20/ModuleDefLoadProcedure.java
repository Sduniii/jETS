package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleDefLoadProcedure extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "MergeId")
    private short MergeId;

    public short getMergeId() { return MergeId; }
    public void setMergeId(short value) { this.MergeId = value; }
}