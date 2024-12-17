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
import com.google.gson.annotations.SerializedName;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "contentId",
        "moviePosterUrl",
        "movie_name",
        "language",
        "genre",
        "releaseDate",
        "rank",
        "language_group"
})

public class UpcomingMovieDatum {

    @JsonProperty("contentId")
    private Integer contentId;
    @JsonProperty("moviePosterUrl")
    private String moviePosterUrl;
    @JsonProperty("movie_name")
    @SerializedName("movie_name")
    private String movieName;
    @JsonProperty("language")
    private String language;
    @JsonProperty("genre")
    private List<String> genre;
    @JsonProperty("releaseDate")
    private String releaseDate;
    @JsonProperty("rank")
    private Integer rank;
    @JsonProperty("language_group")
    @SerializedName("language_group")
    private List<String> languageGroup;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("contentId")
    public Integer getContentId() {
        return contentId;
    }

    @JsonProperty("contentId")
    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    @JsonProperty("moviePosterUrl")
    public String getMoviePosterUrl() {
        return moviePosterUrl;
    }

    @JsonProperty("moviePosterUrl")
    public void setMoviePosterUrl(String moviePosterUrl) {
        this.moviePosterUrl = moviePosterUrl;
    }

    @JsonProperty("movie_name")
    public String getMovieName() {
        return movieName;
    }

    @JsonProperty("movie_name")
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("genre")
    public List<String> getGenre() {
        return genre;
    }

    @JsonProperty("genre")
    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    @JsonProperty("releaseDate")
    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("releaseDate")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @JsonProperty("rank")
    public Integer getRank() {
        return rank;
    }

    @JsonProperty("rank")
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @JsonProperty("language_group")
    public List<String> getLanguageGroup() {
        return languageGroup;
    }

    @JsonProperty("language_group")
    public void setLanguageGroup(List<String> languageGroup) {
        this.languageGroup = languageGroup;
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