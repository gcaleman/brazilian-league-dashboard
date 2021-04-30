package com.brazilseriea.v1.controller;

import com.brazilseriea.v1.model.Team;
import com.brazilseriea.v1.services.V1Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class V1Controller {

    private V1Service service;

    public V1Controller(V1Service service) {
        this.service = service;
    }

    @GetMapping("/teams")
    public List<String> showAllTeamsNames() {
        return service.getAllTeamsNames();
    }

    @GetMapping("/team/{name}")
    public Team getTeamName(@PathVariable String name) {
        return service.getTeamByName(name);
    }

    @GetMapping("/team/{name}/{season}")
    public Team getTeamName(@PathVariable String name, @PathVariable Long season) {
        return service.getTeamBySeason(name, season);
    }

    @GetMapping("/team/seasons/{name}")
    public List<Long> getTeamSeasons(@PathVariable String name) {
        return service.getSeasonsListFromTeam(name);
    }

    @GetMapping("/team/{team}/home-goals")
    public Integer getTeamScoredHomeGoalsAllSeasons(@PathVariable String team) {
        return service.getTeamScoredHomeGoals(team);
    }

    @GetMapping("/team/{team}/away-goals")
    public Integer getTeamScoredAwayGoalsAllSeasons(@PathVariable String team) {
        return service.getTeamScoredAwayGoals(team);
    }

    @GetMapping("/team/{team}/home-victories")
    public Integer getTeamHomeVictoriesAllSeasons(@PathVariable String team) {
        return service.getTeamHomeVictories(team);
    }

    @GetMapping("/team/{team}/away-victories")
    public Integer getTeamAwayVictoriesAllSeasons(@PathVariable String team) {
        return service.getTeamAwayVictories(team);
    }

    @GetMapping("/team/{team}/draws")
    public Integer getTeamDrawsAllSeasons(@PathVariable String team) {
        return service.getTeamDraws(team);
    }

    @GetMapping("/team/{team}/lost")
    public Integer getTeamLostAllSeasons(@PathVariable String team) {
        Integer lost = 0;
        lost = service.getTotalGames(team) - service.getTeamAwayVictories(team) - service.getTeamHomeVictories(team) - service.getTeamDraws(team);
        return lost;
    }

}
