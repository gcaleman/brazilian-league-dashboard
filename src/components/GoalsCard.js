import { React } from 'react';

export const GoalsCard = ({ team }) => {

    if (!team.matches) {
        return <h1>Goals not found!</h1>
    }

    const teamHomeGoals = () => {
        let homeGoals = 0;
        let listHomeGoals = [];
        team.matches.map(matches => {
            if (matches.home.toUpperCase() === team.teamName.toUpperCase()) {
                listHomeGoals.push(matches.hg);
            }
        })
        for (let index = 0; index < listHomeGoals.length; index++) {
            homeGoals = homeGoals + listHomeGoals[index];
        }

        return homeGoals;
    }

    const teamHomeGoalsTaken = () => {
        let homeGoals = 0;
        let listHomeGoals = [];
        team.matches.map(matches => {
            if (matches.home.toUpperCase() === team.teamName.toUpperCase()) {
                listHomeGoals.push(matches.ag);
            }
        })
        for (let index = 0; index < listHomeGoals.length; index++) {
            homeGoals = homeGoals + listHomeGoals[index];
        }

        return homeGoals;
    }

    const teamAwayGoals = () => {
        let awayGoals = 0;
        let listAwayGoals = [];
        team.matches.map(matches => {
            if (matches.away.toUpperCase() === team.teamName.toUpperCase()) {
                listAwayGoals.push(matches.ag);
            }
        })
        for (let index = 0; index < listAwayGoals.length; index++) {
            awayGoals = awayGoals + listAwayGoals[index];
        }

        return awayGoals;
    }

    const teamAwayGoalsTaken = () => {
        let awayGoals = 0;
        let listAwayGoals = [];
        team.matches.map(matches => {
            if (matches.away.toUpperCase() === team.teamName.toUpperCase()) {
                listAwayGoals.push(matches.hg);
            }
        })
        for (let index = 0; index < listAwayGoals.length; index++) {
            awayGoals = awayGoals + listAwayGoals[index];
        }

        return awayGoals;
    }

    return (
        <div className="GoalsCard">
            <h3>Goals Scored Home: {teamHomeGoals()}</h3>
            <hr></hr>
            <h3>Goals Scored Away: {teamAwayGoals()}</h3>
            <hr></hr>
            <h3>Goals Taken Home: {teamHomeGoalsTaken()}</h3>
            <hr></hr>
            <h3>Goals Taken Away: {teamAwayGoalsTaken()}</h3>
        </div>
    )
}