package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Trades extends KnxBase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Trade")
    private java.util.List<Trade> Trade = new java.util.ArrayList<>();

    public java.util.List<Trade> getTrade() { return Trade; }
    public void setTrade(java.util.List<Trade> value) { this.Trade = value; }
}