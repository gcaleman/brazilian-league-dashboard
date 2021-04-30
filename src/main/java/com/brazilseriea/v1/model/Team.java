package com.brazilseriea.v1.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String teamName;
    private Long games;
    private Long seasons;
    private Long wins;
    private Long losts;
    private Long draws;
    private Long homeScores;
    private Long awayScores;
    private Long homeScoresAgainst;
    private Long awayScoresAgainst;
    @Transient
    private List<Match> matches;

    public Team() {
    }

    public Team(String teamName, Long games) {
        this.teamName = teamName;
        this.games = games;
    }

    public Team(Long id, String teamName, Long games, Long seasons, Long wins, Long losts, Long draws, Long homeScores, Long awayScores, Long homeScoresAgainst, Long awayScoresAgainst, List<Match> matches) {
        this.id = id;
        this.teamName = teamName;
        this.games = games;
        this.seasons = seasons;
        this.wins = wins;
        this.losts = losts;
        this.draws = draws;
        this.homeScores = homeScores;
        this.awayScores = awayScores;
        this.homeScoresAgainst = homeScoresAgainst;
        this.awayScoresAgainst = awayScoresAgainst;
        this.matches = matches;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Long getGames() {
        return games;
    }

    public void setGames(Long games) {
        this.games = games;
    }

    public Long getSeasons() {
        return seasons;
    }

    public void setSeasons(Long seasons) {
        this.seasons = seasons;
    }

    public Long getWins() {
        return wins;
    }

    public void setWins(Long wins) {
        this.wins = wins;
    }

    public Long getLosts() {
        return losts;
    }

    public void setLosts(Long losts) {
        this.losts = losts;
    }

    public Long getDraws() {
        return draws;
    }

    public void setDraws(Long draws) {
        this.draws = draws;
    }

    public Long getHomeScores() {
        return homeScores;
    }

    public void setHomeScores(Long homeScores) {
        this.homeScores = homeScores;
    }

    public Long getAwayScores() {
        return awayScores;
    }

    public void setAwayScores(Long awayScores) {
        this.awayScores = awayScores;
    }

    public Long getHomeScoresAgainst() {
        return homeScoresAgainst;
    }

    public void setHomeScoresAgainst(Long homeScoresAgainst) {
        this.homeScoresAgainst = homeScoresAgainst;
    }

    public Long getAwayScoresAgainst() {
        return awayScoresAgainst;
    }

    public void setAwayScoresAgainst(Long awayScoresAgainst) {
        this.awayScoresAgainst = awayScoresAgainst;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", games=" + games +
                '}';
    }
}
