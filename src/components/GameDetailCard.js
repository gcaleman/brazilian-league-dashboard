import { React } from 'react';
import { Col, Container, Row } from 'react-bootstrap';

export const GameDetailCard = ({ match }) => {

    if (!match) {
        return <h1>Not Found!</h1>
    }

    return (
        <div className="GameDetailCard">
            <Container>
                <Row>
                    <Col md='6'>
                        <h3 className="h3header">{match.home} vs {match.away}</h3>
                        <hr></hr>
                    </Col>
                    <Col md='6'>
                        <h3 className="h3header">{match.date}</h3>
                        <hr></hr>
                    </Col>
                </Row>
                <Row >
                    <Col md='4'>

                    </Col>
                    <Col md='4' style={{ borderLeft: '1px solid navy', borderRight: '1px solid navy', borderRadius:'1px' }}>
                        <h2 style={{ textAlign: 'center', padding: '30px' }}>{match.home}</h2>
                    </Col>
                </Row>
                <Row>
                    <Col md='4'>

                    </Col>
                    <Col md='4' style={{ borderLeft: '1px solid navy', borderRight: '1px solid navy', borderRadius:'1px' }}>
                        <h3 style={{ textAlign: 'center', padding: '10px', color: 'navy' }}>({match.hg})</h3>
                    </Col>
                </Row>
                <Row>
                    <Col md='4'>

                    </Col>
                    <Col md='4' style={{ borderLeft: '1px solid navy', borderRight: '1px solid navy', borderRadius:'1px' }}>
                        <h1 style={{ textAlign: 'center', padding: '20px', color: 'black' }}>X</h1>
                    </Col>
                </Row>
                <Row>
                    <Col md='4'>

                    </Col>
                    <Col md='4' style={{ borderLeft: '1px solid navy', borderRight: '1px solid navy', borderRadius:'1px' }}>
                        <h3 style={{ textAlign: 'center', padding: '10px', color: 'navy' }}>({match.ag})</h3>
                    </Col>
                </Row>
                <Row>
                    <Col md='4'>

                    </Col>
                    <Col md='4' style={{ borderLeft: '1px solid navy', borderRight: '1px solid navy', borderRadius:'1px' }}>
                        <h2 style={{ textAlign: 'center', padding: '30px' }}>{match.away}</h2>
                    </Col>
                </Row>
            </Container>
        </div>
    )
}