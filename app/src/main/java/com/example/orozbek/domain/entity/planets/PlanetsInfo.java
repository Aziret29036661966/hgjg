package com.example.orozbek.domain.entity.planets;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlanetsInfo {

    private int count;
    private String next;
    @SerializedName("previous")
    private String prev;
    private List<PlanetsResult> results;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public List<PlanetsResult> getResults() {
        return results;
    }

    public void setResults(List<PlanetsResult> results) {
        this.results = results;
    }

}
