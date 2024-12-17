package com.aditya.rapidapi;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "elapse",
        "results",
        "total"
})

public class Example {

    @JsonProperty("elapse")
    private Double elapse;
    @JsonProperty("results")
    private List<ResultItem> results;
    @JsonProperty("total")
    private Integer total;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("elapse")
    public Double getElapse() {
        return elapse;
    }

    @JsonProperty("elapse")
    public void setElapse(Double elapse) {
        this.elapse = elapse;
    }

    @JsonProperty("results")
    public List<ResultItem> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<ResultItem> results) {
        this.results = results;
    }

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
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