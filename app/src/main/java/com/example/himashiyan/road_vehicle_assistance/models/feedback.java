package com.example.himashiyan.road_vehicle_assistance.models;

public class feedback {

    public String cusid;
    public Float rating;
    public String title;
    public String desc;


    public feedback() {
    }

    public feedback(String cusid, float rating,String title, String desc) {

        this.cusid = cusid;
        this.rating = rating;
        this.title = title;
        this.desc = desc;
    }
    public String getCusid() {
        return cusid;
    }

    public void setCusid(String cusid) {
        this.cusid = cusid;
    }



    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }



    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }



    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
