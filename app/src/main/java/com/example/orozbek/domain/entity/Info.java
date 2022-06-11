package com.example.orozbek.domain.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Info {
    private int count;
    private String next;
    @SerializedName("previous")
    private String prev;
    private List<Result> results;


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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
