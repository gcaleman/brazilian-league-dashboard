import { React } from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import { FaLinkedin, FaGithub } from 'react-icons/fa';

export const Footer = () => {

    const openLinkedin = () => {
        window.open("https://www.linkedin.com/in/guilherme-mocillo-caleman/")
    }

    const openGithub = () => {
        window.open("https://www.github.com/gcaleman/")
    }

    return (
        <div className="Footer">
            <Container>
                <Row>
                    <Col md={4}>
                        <div style={{ textAlign: 'left', color: 'white' }}>@Copyright</div>
                    </Col>
                    <Col md={2}>
                        <div style={{ textAlign: 'center' }}><FaLinkedin className="icon" style={{ color: 'white' }} onClick={openLinkedin} /></div>
                    </Col>
                    <Col md={2}>
                        <div style={{ textAlign: 'center' }}><FaGithub className="icon" style={{ color: 'white' }} onClick={openGithub} /></div>
                    </Col>
                </Row>
            </Container>
        </div>
    )
}