import { React, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { SeasonGamesCard } from '../components/SeasonGamesCard';
import { Container, Row, Col, Navbar } from 'react-bootstrap';
import { GoalsCard } from '../components/GoalsCard';
import { ResultsCard } from '../components/ResultsCard';
import { BackButton } from '../components/BackButton';

export const SeasonDetailPage = () => {

    const [team, setTeam] = useState({ matches: [] });

    const { teamName, season } = useParams();

    useEffect(
        () => {
            const fetchData = async () => {
                const response = await fetch(`http://localhost:8080/team/${teamName}/${season}`);
                const data = await response.json();
                setTeam(data);
            }
            fetchData();
        }, [teamName, season]
    )


    if (!team || !team.teamName || !team.matches) {
        return <h1>Loading..</h1>
    }

    return (
        <div className="SeasonDetailPage">
            <Navbar bg="light" variant="light">
                <img
                    src={`/logos/${team.teamName}.png`}
                    width="35"
                    height="40"
                    className="d-inline-block align-top icon"
                    alt={team.teamName}
                />
                <Container>
                    <Row>
                        <Col md={1}></Col>
                        <Col md={11}>
                            <Navbar.Brand href={`/team/${team.teamName}`}><h4>{team.teamName}</h4></Navbar.Brand>
                        </Col>
                    </Row>
                </Container>
            </Navbar>
            <Container>
                <Row>
                    <Col md={4} >
                        <h4 className="h3header">Matches</h4>
                        <hr></hr>
                        <SeasonGamesCard team={team} />
                    </Col>
                    <Col md={4} style={{ position: 'center' }}>
                        <h4 className="h3header">Goals</h4>
                        <hr></hr>
                        <GoalsCard team={team} />
                    </Col>
                    <Col md={4} style={{ position: 'center' }}>
                        <h4 className="h3header">Results Chart</h4>
                        <hr></hr>
                        <ResultsCard team={team} />
                    </Col>
                </Row>
            </Container>
            <BackButton />
        </div>
    )

}