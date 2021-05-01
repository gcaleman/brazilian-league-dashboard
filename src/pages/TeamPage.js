import {React, useEffect, useState} from 'react';
import { TeamList } from '../components/TeamList';


export const TeamPage = () => {

    const [list, setList] = useState([]);

    useEffect (
        () => {
            const fetchTeamsList = async () => {
                const response = await fetch('http://localhost:8080/teams');
                const data = await response.json();
                setList(data);
            }
            fetchTeamsList();
        }, []
    )

    return (
        <div className="TeamPage">
            <h1 className="header">List of teams that played Serie A - 2012/2020</h1>
               <TeamList list={list}/>
        </div>
    )

}