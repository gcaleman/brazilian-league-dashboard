package com.brazilseriea.v1.data;

public class MatchInput {

    private String id;
    private String season;
    private String date;
    private String time;
    private String home;
    private String away;
    private String hg;
    private String ag;
    private String res;

    public MatchInput() {
    }

    public MatchInput(String id, String season, String date, String time, String home, String away, String hg, String ag, String res) {
        this.id = id;
        this.season = season;
        this.date = date;
        this.time = time;
        this.home = home;
        this.away = away;
        this.hg = hg;
        this.ag = ag;
        this.res = res;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public String getHg() {
        return hg;
    }

    public void setHg(String hg) {
        this.hg = hg;
    }

    public String getAg() {
        return ag;
    }

    public void setAg(String ag) {
        this.ag = ag;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }
}
