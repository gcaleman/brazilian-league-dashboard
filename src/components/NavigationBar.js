import React from 'react';
import { Navbar } from 'react-bootstrap';

export const NavigationBar = () => (
  <Navbar bg="primary" variant="dark" sticky="top">
    <img 
      src="/logo-brasileirao-2048.png"
      width="35"
      height="40"
      className="d-inline-block align-top icon"
      alt=""
    />
    <Navbar.Brand href="/">Brazilian League</Navbar.Brand>
  </Navbar>
)