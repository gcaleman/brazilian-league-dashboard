import { React, useState, useRef } from 'react';
import { Link } from 'react-router-dom';

export const SeasonGamesCard = (props) => {

    if (!props.list) {
        return <h1>Team not found! =)</h1>
    }

    return (
        <div className="SeasonGamesCard">
            {props.list.map((match, index) => {
                const gameDetailLink = `/match/${match.home}/${match.away}/${match.season}`;
                return (
                    <ol key={index}>
                        <h3 > <Link to={gameDetailLink}>{match.home} vs {match.away}</Link> </h3>
                        <hr></hr>
                    </ol>
                )
            })}
        </div>
    )

}