package com.aditya.rapidapi;


//package javainuse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Root {
    private String draw;
    private Integer recordsTotal;
    private Integer recordsFiltered;
    private List<Datum> data = new ArrayList<Datum>();
    private List<Object> news = new ArrayList<Object>();
    private Boolean query;
    public String getDraw() {
        return draw;
    }
    public void setDraw(String draw) {
        this.draw = draw;
    }
    public Integer getRecordsTotal() {
        return recordsTotal;
    }
    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }
    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }
    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
    public List<Datum> getData() {
        return data;
    }
    public void setData(List<Datum> data) {
        this.data = data;
    }
    public List<Object> getNews() {
        return news;
    }
    public void setNews(List<Object> news) {
        this.news = news;
    }
    public Boolean getQuery() {
        return query;
    }
    public void setQuery(Boolean query) {
        this.query = query;
    }
}
