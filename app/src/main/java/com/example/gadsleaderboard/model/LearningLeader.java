package com.example.gadsleaderboard.model;

public class LearningLeader {
    private String mName;
    private String mCountry;
    private int mHours;

    public LearningLeader(String name, String country, int hours){
        this.mName = name;
        this.mCountry = country;
        this.mHours = hours;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        this.mCountry = country;
    }

    public int getHours() {
        return mHours;
    }

    public void setHours(int hours) {
        this.mHours = hours;
    }
}
