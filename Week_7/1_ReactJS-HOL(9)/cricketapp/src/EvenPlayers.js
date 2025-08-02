import React from 'react';

function EvenPlayers({ players }) {
  const [second, fourth, sixth] = players;

  return (
    <ul>
      <li>2nd: {second}</li>
      <li>4th: {fourth}</li>
      <li>6th: {sixth}</li>
    </ul>
  );
}

export default EvenPlayers;