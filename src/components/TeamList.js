import {React} from 'react';

export const TeamList = ({list}) => {
    return (
        <div className="TeamList">
          {list.map((teams, index) => <p key={index}>{teams}</p>)}
        </div>
      );
}