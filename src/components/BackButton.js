import {React} from 'react';
import {Button} from 'react-bootstrap';

export const BackButton = () => {

    const buttonStyle = {
        position: 'fixed',
        bottom: '0px',
        right: '0px'
    }

    const goBack = () => { 
        window.history.back();
    }

    return (
        <Button onClick={goBack} style={buttonStyle}>Go Back</Button>
    )
}