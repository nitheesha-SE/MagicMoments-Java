
package com.bev.shoppinglist.model.walmart;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "multi",
    "nullCount"
})
public class Properties {

    @JsonProperty("multi")
    private String multi;
    @JsonProperty("nullCount")
    private String nullCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("multi")
    public String getMulti() {
        return multi;
    }

    @JsonProperty("multi")
    public void setMulti(String multi) {
        this.multi = multi;
    }

    @JsonProperty("nullCount")
    public String getNullCount() {
        return nullCount;
    }

    @JsonProperty("nullCount")
    public void setNullCount(String nullCount) {
        this.nullCount = nullCount;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
