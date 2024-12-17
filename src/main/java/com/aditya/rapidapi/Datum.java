package com.aditya.rapidapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Datum {
    private String id;
    private String link;
    private String image;
    private String title;
    @SerializedName("theatrical-date")
    private String theatricalYear;
    @SerializedName("release-year")
    private String releaseYear;
    @SerializedName("streaming-date")
    private String streamingDate;
    private String category;
    private String genre;
    private String languages;
    private List<String> platform;
    private String recommended;
    private String recommendation;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTheatricalYear() {
        return theatricalYear;
    }
    public void setTheatricalYear(String theatricalYear) {
        this.theatricalYear = theatricalYear;
    }
    public String getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }
    public String getStreamingDate() {
        return streamingDate;
    }
    public void setStreamingDate(String streamingDate) {
        this.streamingDate = streamingDate;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getLanguages() {
        return languages;
    }
    public void setLanguages(String languages) {
        this.languages = languages;
    }
    public List<String> getPlatform() {
        return platform;
    }
    public void setPlatform(List<String> platform) {
        this.platform = platform;
    }
    public String getRecommended() {
        return recommended;
    }
    public void setRecommended(String recommended) {
        this.recommended = recommended;
    }
    public String getRecommendation() {
        return recommendation;
    }
    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
