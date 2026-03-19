package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComObjectParameterBlock_Rows extends KnxBase {
    @JacksonXmlProperty(localName = "Row")
    private ComObjectParameterBlock_Rows_Row Row = null;

    public ComObjectParameterBlock_Rows_Row getRow() { return Row; }
    public void setRow(ComObjectParameterBlock_Rows_Row value) { this.Row = value; }
}