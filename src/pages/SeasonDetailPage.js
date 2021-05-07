import { React, useEffect, useState, useRef } from 'react';
import { useParams } from 'react-router-dom';
import { SeasonGamesCard } from '../components/SeasonGamesCard';
import { Container, Row, Col, Navbar, Form } from 'react-bootstrap';
import { GoalsCard } from '../components/GoalsCard';
import { ResultsCard } from '../components/ResultsCard';
import { BackButton } from '../components/BackButton';

export const SeasonDetailPage = () => {

    const [team, setTeam] = useState({ matches: [] });
    const [searchTerm, setSearchTerm] = useState("");
    const [searchResults, setsearchResults] = useState([]);

    const inputEl = useRef("");

    const { teamName, season } = useParams();

    useEffect(
        () => {
            const fetchData = async () => {
                const response = await fetch(`http://brazilianleaguedashboardapi-env.eba-nck3umht.eu-west-1.elasticbeanstalk.com/team/${teamName}?season=${season}`);
                const data = await response.json();
                setTeam(data);
            }
            fetchData();
        }, [teamName, season]
    )


    if (!team || !team.teamName || !team.matches) {
        return <h1>Loading..</h1>
    }

    const list = team.matches;

    const getSearchTerm = () => {
        setSearchTerm(inputEl.current.value);
        if (searchTerm) {
            const newMatchList = list.filter(matches => {
                return Object.values(matches).join(" ").toLowerCase().includes(searchTerm.toLowerCase())
            });
            setsearchResults(newMatchList);
        } else {
            setsearchResults(list);
        }
    }

    return (
        <div className="SeasonDetailPage">
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
                <Col md={5}>
                    <Form.Group>
                        <Form.Control ref={inputEl} type="text" placeholder="Search team" value={searchTerm} onChange={getSearchTerm} />
                    </Form.Group>
                </Col>
            </Navbar>
            <Container>
                <Row>
                    <Col md={4} >
                        <h4 className="h3header">Matches</h4>
                        <hr></hr>
                        <SeasonGamesCard list={searchTerm.length < 1 ? list : searchResults} />
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
            <BackButton team={team.teamName} />
        </div>
    )

}