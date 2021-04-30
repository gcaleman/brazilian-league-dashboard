package com.brazilseriea.v1.services;

import com.brazilseriea.v1.model.Match;
import com.brazilseriea.v1.model.Team;
import com.brazilseriea.v1.repository.MatchRepository;
import com.brazilseriea.v1.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class V1Service {

    private MatchRepository matchRepository;
    private TeamRepository teamRepository;

    public V1Service(MatchRepository matchRepository, TeamRepository teamRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
    }

    public List<Team> findAll() {
        List<Team> teams = new ArrayList<>();
        teamRepository.findAll().forEach(teams::add);
        return teams;
    }

    public List<String> getAllTeamsNames() {
        List<String> teamName = new ArrayList<>();
        findAll().stream().forEach(team -> teamName.add(team.getTeamName()));
        return teamName;
    }

    public Team getTeamByName(String name) {
        Team team = this.teamRepository.findByTeamName(name);
        List<Match> getTeam = matchRepository.getByHomeOrAwayOrderBySeasonAsc(name, name);
        team.setMatches(getTeam);
        return team;
    }

    public Team getTeamBySeason(String name, Long season) {
        Team team = this.teamRepository.findByTeamName(name);
        List<Match> getTeam = matchRepository.getByHomeOrAwayOrderBySeasonAsc(name, name);
        List<Match> matchesBySeason = new ArrayList<>();
        getTeam.stream().forEach(match -> {
            if (match.getSeason().equals(season))
                matchesBySeason.add(match);
        });
        team.setMatches(matchesBySeason);
        return team;
    }

    public List<Long> getSeasonsListFromTeam(String team) {
        return matchRepository.findDistinctBySeasonAndHome(team);
    }

    public Integer getTeamScoredHomeGoals(String team) {
        Integer scoredHomeGoals = 0;
        List<Integer> homeGoals = new ArrayList<>();
        getTeamByName(team).getMatches().forEach(match -> {
            if (match.getHome().equalsIgnoreCase(team))
            homeGoals.add(match.getHg());
        });
        for (int i = 0; i < homeGoals.size(); i++) {
            scoredHomeGoals += homeGoals.get(i);
        }
        return scoredHomeGoals;
    }

    public Integer getTeamScoredAwayGoals(String team) {
        Integer scoredAwayGoals = 0;
        List<Integer> awayGoals = new ArrayList<>();
        getTeamByName(team).getMatches().forEach(match -> {
            if (match.getAway().equalsIgnoreCase(team))
            awayGoals.add(match.getAg());
        });
        for (int i = 0; i < awayGoals.size(); i++) {
            scoredAwayGoals += awayGoals.get(i);
        }
        return scoredAwayGoals;
    }

    public Integer getTeamHomeVictories(String team) {
        return matchRepository.getTeamHomeVictories(team);
    }

    public Integer getTeamAwayVictories(String team) {
        return matchRepository.getTeamAwayVictories(team);
    }

    public Integer getTeamDraws(String team){
        Integer draws = 0;
        List<Match> drawsList = new ArrayList<>();
        getTeamByName(team).getMatches().forEach(match -> {
            if (match.getRes().equalsIgnoreCase("D"))
                drawsList.add(match);
        });
        draws = drawsList.size();
        return draws;
    }

    public Integer getTotalGames(String team){
        Integer totalGames = 0;
        totalGames = getTeamByName(team).getMatches().size();
        return totalGames;
    }

    public List<Match> getListDraws(String team){
        List<Match> listOfDraws = new ArrayList<>();
        getTeamByName(team).getMatches().forEach(match -> {
            if (match.getRes().equalsIgnoreCase("D"))
                listOfDraws.add(match);
        });
        return listOfDraws;
    }

    public Integer homeDraws(String team){
        Integer homeDraws = 0;
        List<Match> homeDrawsList = new ArrayList<>();
        getListDraws(team).forEach(draw -> {
            if (draw.getHome().equalsIgnoreCase(team))
                homeDrawsList.add(draw);
        });
        homeDraws = homeDrawsList.size();
        return homeDraws;
    }

    public Integer AwayDraws(String team){
        Integer awayDraws = 0;
        List<Match> awayDrawsList = new ArrayList<>();
        getListDraws(team).forEach(draw -> {
            if (draw.getAway().equalsIgnoreCase(team))
                awayDrawsList.add(draw);
        });
        awayDraws = awayDrawsList.size();
        return awayDraws;
    }

}
