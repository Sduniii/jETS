package de.sduni.jets.model.v20;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class SimpleElementTextType extends KnxBase {
    @JacksonXmlText
    private String text;
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}
