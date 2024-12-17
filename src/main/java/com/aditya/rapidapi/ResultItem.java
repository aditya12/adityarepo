package com.aditya.rapidapi;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "avgrating",
        "clist",
        "id",
        "imdbid",
        "imdbrating",
        "img",
        "nfid",
        "poster",
        "runtime",
        "synopsis",
        "title",
        "titledate",
        "top250",
        "top250tv",
        "vtype",
        "year"
})

public class ResultItem {

    @JsonProperty("avgrating")
    private Double avgrating;
    @JsonProperty("clist")
    private String clist;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("imdbid")
    private String imdbid;
    @JsonProperty("imdbrating")
    private Double imdbrating;
    @JsonProperty("img")
    private String img;
    @JsonProperty("nfid")
    private Integer nfid;
    @JsonProperty("poster")
    private String poster;
    @JsonProperty("runtime")
    private Integer runtime;
    @JsonProperty("synopsis")
    private String synopsis;
    @JsonProperty("title")
    private String title;
    @JsonProperty("titledate")
    private String titledate;
    @JsonProperty("top250")
    private Integer top250;
    @JsonProperty("top250tv")
    private Integer top250tv;
    @JsonProperty("vtype")
    private String vtype;
    @JsonProperty("year")
    private Integer year;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("avgrating")
    public Double getAvgrating() {
        return avgrating;
    }

    @JsonProperty("avgrating")
    public void setAvgrating(Double avgrating) {
        this.avgrating = avgrating;
    }

    @JsonProperty("clist")
    public String getClist() {
        return clist;
    }

    @JsonProperty("clist")
    public void setClist(String clist) {
        this.clist = clist;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("imdbid")
    public String getImdbid() {
        return imdbid;
    }

    @JsonProperty("imdbid")
    public void setImdbid(String imdbid) {
        this.imdbid = imdbid;
    }

    @JsonProperty("imdbrating")
    public Double getImdbrating() {
        return imdbrating;
    }

    @JsonProperty("imdbrating")
    public void setImdbrating(Double imdbrating) {
        this.imdbrating = imdbrating;
    }

    @JsonProperty("img")
    public String getImg() {
        return img;
    }

    @JsonProperty("img")
    public void setImg(String img) {
        this.img = img;
    }

    @JsonProperty("nfid")
    public Integer getNfid() {
        return nfid;
    }

    @JsonProperty("nfid")
    public void setNfid(Integer nfid) {
        this.nfid = nfid;
    }

    @JsonProperty("poster")
    public String getPoster() {
        return poster;
    }

    @JsonProperty("poster")
    public void setPoster(String poster) {
        this.poster = poster;
    }

    @JsonProperty("runtime")
    public Integer getRuntime() {
        return runtime;
    }

    @JsonProperty("runtime")
    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    @JsonProperty("synopsis")
    public String getSynopsis() {
        return synopsis;
    }

    @JsonProperty("synopsis")
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("titledate")
    public String getTitledate() {
        return titledate;
    }

    @JsonProperty("titledate")
    public void setTitledate(String titledate) {
        this.titledate = titledate;
    }

    @JsonProperty("top250")
    public Integer getTop250() {
        return top250;
    }

    @JsonProperty("top250")
    public void setTop250(Integer top250) {
        this.top250 = top250;
    }

    @JsonProperty("top250tv")
    public Integer getTop250tv() {
        return top250tv;
    }

    @JsonProperty("top250tv")
    public void setTop250tv(Integer top250tv) {
        this.top250tv = top250tv;
    }

    @JsonProperty("vtype")
    public String getVtype() {
        return vtype;
    }

    @JsonProperty("vtype")
    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

    @JsonProperty("year")
    public Integer getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(Integer year) {
        this.year = year;
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