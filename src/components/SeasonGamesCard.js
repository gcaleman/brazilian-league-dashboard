import { React } from 'react';
import { Link } from 'react-router-dom';
import { Card } from 'react-bootstrap';
import './SeasonGamesCard.css';

export const SeasonGamesCard = (props) => {

    if (!props.list) {
        return <h1>Team not found! =)</h1>
    }

    return (
        <div className="games_list">
                {props.list.map((match, index) => {
                    const gameDetailLink = `/match/${match.home}/${match.away}/${match.season}`;
                    return (
                        <Link style={{ color: 'navy', textDecoration: 'none' }} to={gameDetailLink}>
                            <Card className='games_card' key={index}>
                                <ol>
                                    <h5 > {match.home} vs {match.away}</h5>
                                </ol>
                            </Card>
                        </Link>
                    )
                })}
        </div>
    )
}