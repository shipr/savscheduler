package org.sav.domain;

import org.codehaus.jackson.annotate.JsonProperty;

public class Option{


    @JsonProperty("DisplayText")
    public String displayText;
    @JsonProperty("Value")
    public long value;

    public Option(String displayText, long value) {
        this.displayText = displayText;
        this.value = value;
    }
}
