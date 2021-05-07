package com.brazilseriea.v1.controller;

import com.brazilseriea.v1.model.Team;
import com.brazilseriea.v1.response.NotAcceptable;
import com.brazilseriea.v1.response.NotFound;
import com.brazilseriea.v1.services.V1Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/teams/{name}")
    public Team getTeamName(@PathVariable String name) {
        List<String> checkName = new ArrayList<>();
        if (name.isEmpty()) {
            throw new NotAcceptable("Please enter team name!");
        }
        showAllTeamsNames().stream().forEach(team -> {
            if (name.equalsIgnoreCase(team)) checkName.add(team);
        });
        if (checkName.isEmpty()) throw new NotFound("Team not found. Check spelling.");
        
        return service.getTeamByName(name);
    }

    @GetMapping("/team/{name}")
    public Team getTeamNameSeason(@PathVariable String name, @RequestParam Long season) {
        if (getTeamName(name).getMatches().isEmpty()) {
            throw new NotFound("Team not found!");
        } else {
            if (getTeamSeasons(name).isEmpty())
                throw new NotFound("Invalid Season.");
        }
        return service.getTeamBySeason(name, season);
    }

    @GetMapping("/team/seasons/{name}")
    public List<Long> getTeamSeasons(@PathVariable String name) {
        if (service.getSeasonsListFromTeam(name).isEmpty())
            throw new NotFound("Team not found.");
        return service.getSeasonsListFromTeam(name);
    }

//    @GetMapping("/team/home-goals/{team}")
//    public Integer getTeamScoredHomeGoalsAllSeasons(@PathVariable String team) {
//        return service.getTeamScoredHomeGoals(team);
//    }
//
//    @GetMapping("/team/{team}/home-given-goals")
//    public Integer getTeamGivenHomeGoalsAllSeasons(@PathVariable String team) {
//        return service.getTeamGivenHomeGoals(team);
//    }
//
//    @GetMapping("/team/{team}/away-goals")
//    public Integer getTeamScoredAwayGoalsAllSeasons(@PathVariable String team) {
//        return service.getTeamScoredAwayGoals(team);
//    }
//
//    @GetMapping("/team/{team}/away-given-goals")
//    public Integer getTeamGivenAwayGoalsAllSeasons(@PathVariable String team) {
//        return service.getTeamGivenAwayGoals(team);
//    }

//    @GetMapping("/team/{team}/home-victories")
//    public Integer getTeamHomeVictoriesAllSeasons(@PathVariable String team) {
//        return service.getTeamHomeVictories(team);
//    }
//
//    @GetMapping("/team/{team}/away-victories")
//    public Integer getTeamAwayVictoriesAllSeasons(@PathVariable String team) {
//        return service.getTeamAwayVictories(team);
//    }
//
//    @GetMapping("/team/{team}/draws")
//    public Integer getTeamDrawsAllSeasons(@PathVariable String team) {
//        return service.getTeamDraws(team);
//    }
//
//    @GetMapping("/team/{team}/draws-home")
//    public Integer getTeamDrawsHome(@PathVariable String team) {
//        return service.homeDraws(team);
//    }
//
//    @GetMapping("/team/{team}/draws-away")
//    public Integer getTeamDrawsAway(@PathVariable String team) {
//        return service.awayDraws(team);
//    }
//
//    @GetMapping("/team/{team}/lost")
//    public Integer getTeamLostAllSeasons(@PathVariable String team) {
//        return service.getListLost(team).size();
//    }
//
//    @GetMapping("/team/{team}/lost-home")
//    public Integer getTeamLostHome(@PathVariable String team) {
//        return service.getHomeLost(team).size();
//    }
//
//    @GetMapping("/team/{team}/lost-away")
//    public Integer getTeamLostAway(@PathVariable String team) {
//        return service.getAwayLost(team).size();
//    }

}
