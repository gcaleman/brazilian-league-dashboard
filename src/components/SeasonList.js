import { React, useEffect, useState } from 'react';
import { Card } from 'react-bootstrap';
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
        <>
            {seasonList.map((seasons, index) => {
                const seasonLink = `/season/${teamName}/${seasons}`;
                return (
                    <Link style={{ fontSize: '30px', color: 'navy', textDecoration: 'none' }} to={seasonLink}>
                        <Card className='games_card'>
                            <ol key={index}>
                                <h5>{seasons}</h5>
                            </ol>
                        </Card>
                    </Link>
                )
            })}
        </>
    )
}
