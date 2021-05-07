import {React} from 'react';
import {Button} from 'react-bootstrap';

export const BackButton = ({team}) => {

    if (!team) {
        return(
            <h4>Error!</h4>
        )
    }

    const buttonStyle = {
        position: 'fixed',
        bottom: '70px',
        right: '0px',
    }

    const goBack = () => { 
        window.history.back();
    }

    return (
        <Button onClick={goBack} variant={team === "Corinthians" ? "dark" : "primary"} style={buttonStyle}>Go Back</Button>
    )
}