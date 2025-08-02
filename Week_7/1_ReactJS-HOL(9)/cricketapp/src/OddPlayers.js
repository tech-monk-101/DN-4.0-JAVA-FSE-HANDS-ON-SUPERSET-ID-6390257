import React from 'react';

function OddPlayers({ players }) {
  const [first, third, fifth] = players;

  return (
    <ul>
      <li>1st: {first}</li>
      <li>3rd: {third}</li>
      <li>5th: {fifth}</li>
    </ul>
  );
}

export default OddPlayers;