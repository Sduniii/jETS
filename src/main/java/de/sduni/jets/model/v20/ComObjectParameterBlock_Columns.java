package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComObjectParameterBlock_Columns extends KnxBase {
    @JacksonXmlProperty(localName = "Column")
    private ComObjectParameterBlock_Columns_Column Column = null;

    public ComObjectParameterBlock_Columns_Column getColumn() { return Column; }
    public void setColumn(ComObjectParameterBlock_Columns_Column value) { this.Column = value; }
}