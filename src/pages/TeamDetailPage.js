import { React, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { GoalsCard } from '../components/GoalsCard';
import { SeasonList } from '../components/SeasonList';
import { Container, Row, Col, Navbar } from 'react-bootstrap';
import { ResultsCard } from '../components/ResultsCard';
import { BackButton } from '../components/BackButton';


export const TeamDetailPage = () => {

    const { handle } = useParams();

    const [team, setTeam] = useState({ matches: [] });

    useEffect(
        () => {
            const fetchTeamData = async () => {
                const response = await fetch(`https://dashboardapi.brazilianleaguedashboard.link/teams/${handle}`);
                const data = await response.json();
                setTeam(data);
            }
            fetchTeamData();
        }, [handle]
    )

    if (!team || !team.teamName || !team.matches) {
        return <h1>Loading..</h1>
    }


    return (
        <div className="TeamDetailPage">
            <Navbar bg={team.teamName === "Corinthians" ? "dark" : "light"} variant={team.teamName === "Corinthians" ? "dark" : "light"}>
                <img
                    src={`/logos/${team.teamName}.png`}
                    width="35"
                    height="40"
                    className="d-inline-block align-top icon"
                    alt={team.teamName}
                />
                <Container>
                    <Row>
                        <Col md={4}>

                        </Col>
                        <Col md={8}>
                            <Navbar.Brand href={`/team/${team.teamName}`}><h4>{team.teamName.toUpperCase()}</h4></Navbar.Brand>
                        </Col>
                    </Row>
                </Container>
            </Navbar>
            <Container>
                <Row>
                    <Col md={4}>
                        <h4 className="h3header">Seasons in Serie A</h4>
                        <hr></hr>
                        <SeasonList teamName={team.teamName} />
                    </Col>
                    <Col md={4} >
                        <h4 className="h3header">Goals Seasons 2012 to 2020</h4>
                        <hr></hr>
                        <GoalsCard team={team} />
                    </Col>
                    <Col md={4} >
                        <h4 className="h3header">Results Chart</h4>
                        <hr></hr>
                        <ResultsCard team={team} />
                    </Col>
                </Row>
            </Container>
            <BackButton team={team.teamName} />
        </div >
    )

}