package com.brazilseriea.v1.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Match {

    @Id
    private Long id;
    private Long season;
    private LocalDate date;
    private LocalTime time;
    private String home;
    private String away;
    private Integer hg;
    private Integer ag;
    private String res;

    public Match() {
    }

    public Match(Long id, Long season, LocalDate date, LocalTime time, String home, String away, Integer hg, Integer ag, String res) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSeason() {
        return season;
    }

    public void setSeason(Long season) {
        this.season = season;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
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

    public Integer getHg() {
        return hg;
    }

    public void setHg(Integer hg) {
        this.hg = hg;
    }

    public Integer getAg() {
        return ag;
    }

    public void setAg(Integer ag) {
        this.ag = ag;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    @Override
    public String toString() {
        return "Match{" +
                "date=" + date +
                ", time=" + time +
                ", home='" + home + '\'' +
                ", away='" + away + '\'' +
                ", hg=" + hg +
                ", ag=" + ag +
                ", res='" + res + '\'' +
                '}';
    }
}
