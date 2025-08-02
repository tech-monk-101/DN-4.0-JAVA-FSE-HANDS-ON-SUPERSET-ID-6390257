import React from 'react';

function MergedList({ players }) {
  return (
    <ul>
      {players.map((player, index) => (
        <li key={index}>Mr. {player}</li>
      ))}
    </ul>
  );
}

export default MergedList;