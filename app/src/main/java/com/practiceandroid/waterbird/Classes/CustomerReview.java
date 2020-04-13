package com.practiceandroid.waterbird.Classes;

public class CustomerReview {
    private String name;
    private String date;
    private String rating;
    private String desc;

    public CustomerReview(String name, String date, String rating, String desc) {
        this.name = name;
        this.date = date;
        this.rating = rating;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
