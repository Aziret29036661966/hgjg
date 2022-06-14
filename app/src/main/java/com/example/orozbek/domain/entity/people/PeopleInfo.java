package com.example.orozbek.domain.entity.people;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeopleInfo {
    private int count;
    private String next;
    @SerializedName("previous")
    private String prev;
    private List<PeopleResult> results;

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

    public List<PeopleResult> getResults() {
        return results;
    }

    public void setResults(List<PeopleResult> results) {
        this.results = results;
    }
}
