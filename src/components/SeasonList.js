import { React, useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

export const SeasonList = ({ teamName }) => {

    const [seasonList, setSeason] = useState([]);

    useEffect(
        () => {
            const fetchTeamSeasons = async () => {
                const response = await fetch(`https://dashboardapi.brazilianleaguedashboard.link/team/seasons/${teamName}`)
                const data = await response.json();
                setSeason(data);
            }
            fetchTeamSeasons();
        }, [teamName]
    )

    return (
        <div className="SeasonList">
            {seasonList.map((seasons, index) => {
                const seasonLink = `/season/${teamName}/${seasons}`;
                return (
                    <ol key={index}>
                        <h3> <Link to={seasonLink}>{seasons}</Link> </h3>
                        <hr></hr>
                    </ol>
                )
            })}
        </div>
    )
}
