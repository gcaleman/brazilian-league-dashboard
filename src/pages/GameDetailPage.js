import { React, useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import { GameDetailCard } from '../components/GameDetailCard';
import { BackButton } from '../components/BackButton';

export const GameDetailPage = () => {

    const { home, away, gameSeason } = useParams();

    const [team, setTeam] = useState({ matches: [] });

    var detailMatch = {};

    const months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];

    useEffect(
        () => {
            const fetchTeamData = async () => {
                const response = await fetch(`https://dashboardapi.brazilianleaguedashboard.link/teams/${home}`);
                const data = await response.json();
                setTeam(data);
            }
            fetchTeamData();
        }, [home, away, gameSeason]
    )

    if (!team || !team.matches) {
        return <h1>Loading..</h1>
    }

    const getDetailMatch = () => {
        team.matches.map(match => {
            if (match.home === home && match.away === away && match.season == gameSeason) {
                detailMatch = match;
                let matchDate = new Date(match.date);
                let formatted_date = matchDate.getDate() + " " + months[matchDate.getMonth()] + " " + matchDate.getFullYear()
                detailMatch.date = formatted_date;
            }
        })
    }

    getDetailMatch();

    return (
        <div className="GameDetailPage">
            <h1 className="header1">
                <img
                    src={`/logos/${detailMatch.home}.png`}
                    width="35"
                    height="40"
                    className="d-inline-block align-top icon"
                    alt={team.teamName}
                />
                <Link to={`/team/${detailMatch.home}`}>  {detailMatch.home}  </Link>
                vs
                <Link to={`/team/${detailMatch.away}`}>  {detailMatch.away}</Link>  <img
                    src={`/logos/${detailMatch.away}.png`}
                    width="35"
                    height="40"
                    className="d-inline-block align-top icon"
                    alt={team.teamName}
                />
            </h1>
            <GameDetailCard match={detailMatch} />
            <BackButton team={team.teamName} />
        </div>
    )
}