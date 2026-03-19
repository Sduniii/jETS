package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterData_FunctionalBlocks extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "FunctionalBlock")
    private java.util.List<MasterData_FunctionalBlocks_FunctionalBlock> FunctionalBlock = new java.util.ArrayList<>();

    public java.util.List<MasterData_FunctionalBlocks_FunctionalBlock> getFunctionalBlock() { return FunctionalBlock; }
    public void setFunctionalBlock(java.util.List<MasterData_FunctionalBlocks_FunctionalBlock> value) { this.FunctionalBlock = value; }
}