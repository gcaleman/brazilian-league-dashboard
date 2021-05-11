import { React } from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import { FaLinkedin, FaGithub } from 'react-icons/fa';

export const Footer = () => {

    const openLinkedin = () => {
        window.open("https://www.linkedin.com/in/guilherme-mocillo-caleman/")
    }

    const openGithub = () => {
        window.open("https://github.com/gcaleman/brazilian-league-dashboard/")
    }

    return (
        <div className="Footer">
            <Container>
                <Row>
                    <Col >
                        <div style={{ textAlign: 'left', color: 'white' }}>@Copyright</div>
                    </Col>
                    <Col >
                        <div style={{ textAlign: 'center' }}><FaLinkedin className="icon" style={{ color: 'white' }} onClick={openLinkedin} /></div>
                    </Col>
                    <Col >
                        <div style={{ textAlign: 'center' }}><FaGithub className="icon" style={{ color: 'white' }} onClick={openGithub} /></div>
                    </Col>
                </Row>
            </Container>
        </div>
    )
}