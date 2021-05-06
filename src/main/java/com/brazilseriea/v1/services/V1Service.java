package com.brazilseriea.v1.services;

import com.brazilseriea.v1.model.Match;
import com.brazilseriea.v1.model.Team;
import com.brazilseriea.v1.repository.MatchRepository;
import com.brazilseriea.v1.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class V1Service {

    private MatchRepository matchRepository;
    private TeamRepository teamRepository;

    public V1Service(MatchRepository matchRepository, TeamRepository teamRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
    }

    public String firstLetterUpperCase(String name) {
        String[] charArray;
        String stringOneLowerCase;
        String stringOneUpperCase;
        String stringTwoLowerCase;
        String stringTwoUpperCase;
        String concat;
        System.out.println(name);
        if (name.contains("-")) {
            charArray = name.split("-");
            stringOneLowerCase = charArray[0].toLowerCase();
            stringTwoLowerCase = charArray[1].toLowerCase();
            stringOneUpperCase = stringOneLowerCase.substring(0, 1).toUpperCase() + stringOneLowerCase.substring(1);
            stringTwoUpperCase = stringTwoLowerCase.substring(0, charArray[1].length()).toUpperCase();
            concat = stringOneUpperCase + "-" + stringTwoUpperCase;
        } else if (name.contains(" ")) {
            charArray = name.split(" ");
            stringOneLowerCase = charArray[0].toLowerCase();
            stringTwoLowerCase = charArray[1].toLowerCase();
            stringOneUpperCase = stringOneLowerCase.substring(0, 1).toUpperCase() + stringOneLowerCase.substring(1);
            stringTwoUpperCase = stringTwoLowerCase.substring(0, 1).toUpperCase() + stringTwoLowerCase.substring(1);
            concat = stringOneUpperCase + " " + stringTwoUpperCase;
        } else {
            String lowerCase = name.toLowerCase();
            concat = lowerCase.substring(0, 1).toUpperCase() + lowerCase.substring(1);
        }

        return concat;
    }

    public List<Team> findAll() {
        List<Team> teams = new ArrayList<>();
        teamRepository.findAll().forEach(teams::add);
        return teams;
    }

    public List<String> getAllTeamsNames() {
        List<String> teamName = new ArrayList<>();
        List<String> sortedNames = new ArrayList<>();
        findAll().stream().forEach(team -> {
            teamName.add(team.getTeamName());
        });
        sortedNames = teamName.stream().sorted().collect(Collectors.toList());
        return (sortedNames);
    }

    public Team getTeamByName(String name) {
        String firstUpper = firstLetterUpperCase(name);
        Team team = this.teamRepository.findByTeamName(firstUpper);
        List<Match> getTeam = matchRepository.getByHomeOrAwayOrderBySeasonAsc(firstUpper, firstUpper);
        team.setMatches(getTeam);
        return team;
    }

    public Team getTeamBySeason(String name, Long season) {
        String firstUpper = firstLetterUpperCase(name);
        Team team = this.teamRepository.findByTeamName(firstUpper);
        List<Match> getTeam = matchRepository.getByHomeOrAwayOrderBySeasonAsc(firstUpper, firstUpper);
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

//    public Integer getTeamScoredHomeGoals(String team) {
//        Integer scoredHomeGoals = 0;
//        List<Integer> homeGoals = new ArrayList<>();
//        getTeamByName(team).getMatches().forEach(match -> {
//            if (match.getHome().equalsIgnoreCase(team))
//                homeGoals.add(match.getHg());
//        });
//        for (int i = 0; i < homeGoals.size(); i++) {
//            scoredHomeGoals += homeGoals.get(i);
//        }
//        return scoredHomeGoals;
//    }
//
//    public Integer getTeamGivenHomeGoals(String team) {
//        Integer givenHomeGoals = 0;
//        List<Integer> homeGivenGoals = new ArrayList<>();
//        getTeamByName(team).getMatches().forEach(match -> {
//            if (match.getHome().equalsIgnoreCase(team))
//                homeGivenGoals.add(match.getAg());
//        });
//        for (int i = 0; i < homeGivenGoals.size(); i++) {
//            givenHomeGoals += homeGivenGoals.get(i);
//        }
//        return givenHomeGoals;
//    }
//
//    public Integer getTeamScoredAwayGoals(String team) {
//        Integer scoredAwayGoals = 0;
//        List<Integer> awayGoals = new ArrayList<>();
//        getTeamByName(team).getMatches().forEach(match -> {
//            if (match.getAway().equalsIgnoreCase(team))
//                awayGoals.add(match.getAg());
//        });
//        for (int i = 0; i < awayGoals.size(); i++) {
//            scoredAwayGoals += awayGoals.get(i);
//        }
//        return scoredAwayGoals;
//    }
//
//    public Integer getTeamGivenAwayGoals(String team) {
//        Integer givenAwayGoals = 0;
//        List<Integer> awayGoals = new ArrayList<>();
//        getTeamByName(team).getMatches().forEach(match -> {
//            if (match.getAway().equalsIgnoreCase(team))
//                awayGoals.add(match.getHg());
//        });
//        for (int i = 0; i < awayGoals.size(); i++) {
//            givenAwayGoals += awayGoals.get(i);
//        }
//        return givenAwayGoals;
//    }

    public Integer getTotalGames(String team) {
        Integer totalGames = 0;
        totalGames = getTeamByName(team).getMatches().size();
        return totalGames;
    }

//    public Integer getTeamHomeVictories(String team) {
//        return matchRepository.getTeamHomeVictories(team);
//    }
//
//    public Integer getTeamAwayVictories(String team) {
//        return matchRepository.getTeamAwayVictories(team);
//    }
//
//    public Integer getTeamDraws(String team) {
//        Integer draws = this.getListDraws(team).size();
//        return draws;
//    }
//
//    public List<Match> getListDraws(String team) {
//        List<Match> listOfDraws = new ArrayList<>();
//        getTeamByName(team).getMatches().forEach(match -> {
//            if (match.getRes().equalsIgnoreCase("D"))
//                listOfDraws.add(match);
//        });
//        return listOfDraws;
//    }
//
//    public Integer homeDraws(String team) {
//        Integer homeDraws = 0;
//        List<Match> homeDrawsList = new ArrayList<>();
//        getListDraws(team).forEach(draw -> {
//            if (draw.getHome().equalsIgnoreCase(team))
//                homeDrawsList.add(draw);
//        });
//        homeDraws = homeDrawsList.size();
//        return homeDraws;
//    }
//
//    public Integer awayDraws(String team) {
//        Integer awayDraws = 0;
//        List<Match> awayDrawsList = new ArrayList<>();
//        getListDraws(team).forEach(draw -> {
//            if (draw.getAway().equalsIgnoreCase(team))
//                awayDrawsList.add(draw);
//        });
//        awayDraws = awayDrawsList.size();
//        return awayDraws;
//    }
//
//    public List<Match> getListLost(String team) {
//        List<Match> listOfLost = new ArrayList<>();
//        getTeamByName(team).getMatches().forEach(match -> {
//            if (match.getHome().equalsIgnoreCase(team) && match.getRes().equalsIgnoreCase("A")
//                    || match.getAway().equalsIgnoreCase(team) && match.getRes().equalsIgnoreCase("H")
//            )
//                listOfLost.add(match);
//        });
//        return listOfLost;
//    }
//
//    public List<Match> getHomeLost(String team) {
//        List<Match> listOfHomeLost = new ArrayList<>();
//        getListLost(team).forEach(match -> {
//            if (match.getHome().equalsIgnoreCase(team))
//                listOfHomeLost.add(match);
//        });
//        return listOfHomeLost;
//    }
//
//    public List<Match> getAwayLost(String team) {
//        List<Match> listOfAwayLost = new ArrayList<>();
//        getListLost(team).forEach(match -> {
//            if (match.getAway().equalsIgnoreCase(team))
//                listOfAwayLost.add(match);
//        });
//        return listOfAwayLost;
//    }

}
