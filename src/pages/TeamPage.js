import { React, useEffect, useState, useRef } from 'react';
import { Container, Row, Col, Form } from 'react-bootstrap';
import { TeamList } from '../components/TeamList';



export const TeamPage = () => {

    const [list, setList] = useState([]);
    const [searchTerm, setSearchTerm] = useState([]);
    const [searchResults, setsearchResults] = useState([]);
    const inputEl = useRef("");

    useEffect(
        () => {
            const fetchTeamsList = async () => {
                const response = await fetch('http://localhost:8080/teams');
                const data = await response.json();
                setList(data);
            }
            fetchTeamsList();
        }, []
    )

    if (!list) {
        return <h1>Loading..</h1>
    }

    const searchHandler = () => {
        setSearchTerm(inputEl.current.value);
        if (inputEl.current.value !== "") {
            const newTeamList = list.filter(team => {
                return team.toLowerCase().includes(inputEl.current.value.toLowerCase());
            });
            setsearchResults(newTeamList);
        } else {
            setsearchResults(list);
        }
    }

    return (
        <div className="TeamPage">
            <h1 className="header">List of Teams - Serie A - 2012/2020</h1>
            <hr></hr>
            <Container>
                <Row>
                    <Col md={1}>
                    </Col>
                    <Col>
                        <Form.Group>
                            <Form.Control ref={inputEl} type="text" placeholder="Search team" value={searchTerm} onChange={searchHandler} />
                        </Form.Group>
                    </Col>
                </Row>
            </Container>
            <Container>
                <Row>
                    <Col md={1} style={{ backgroundColor: 'blue', right: '15px' }}>
                    </Col>
                    <Col md={11}>
                        <TeamList list={searchResults.length < 1 ? list : searchResults} />
                    </Col>
                </Row>
            </Container>

        </div>
    )

}