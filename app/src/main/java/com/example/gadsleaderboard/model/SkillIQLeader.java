package com.example.gadsleaderboard.model;

public class SkillIQLeader {
    private String mName;
    private String mCountry;
    private int mScore;

    public SkillIQLeader(String name, String country, int score){
        this.mName = name;
        this.mCountry = country;
        this.mScore = score;
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

    public int getScore() {
        return mScore;
    }

    public void setScore(int score) {
        this.mScore = score;
    }
}


