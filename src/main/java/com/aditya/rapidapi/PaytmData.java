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
        "upcomingMovieData"
})

public class PaytmData {

    @JsonProperty("upcomingMovieData")
    private List<UpcomingMovieDatum> upcomingMovieData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("upcomingMovieData")
    public List<UpcomingMovieDatum> getUpcomingMovieData() {
        return upcomingMovieData;
    }

    @JsonProperty("upcomingMovieData")
    public void setUpcomingMovieData(List<UpcomingMovieDatum> upcomingMovieData) {
        this.upcomingMovieData = upcomingMovieData;
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