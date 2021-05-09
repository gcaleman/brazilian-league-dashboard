import { React } from 'react';
import { Link } from "react-router-dom";

export const TeamList = ({ list }) => {

  return (
    <div className="TeamList" style={{ borderLeft: '2px solid navy', padding: '10px' }}>
      {list.map((teams, index) => {
        const teamLink = `/team/${teams}`
        return (
          <ol className="listPadding" key={index}>
            <Link style={{ fontSize: '30px', color:'navy' }} to={teamLink}>{teams}</Link>
            <hr></hr>
          </ol>
        )
      })}
    </div>
  );
}