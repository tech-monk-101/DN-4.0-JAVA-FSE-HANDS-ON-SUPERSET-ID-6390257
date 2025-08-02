import React from 'react';

function ScoreBelow70({ players }) {
  const filtered = players.filter(player => player.score < 70);

  return (
    <ul>
      {filtered.map(player => (
        <li key={player.name}>
          Mr. {player.name}{' '}
          <span style={{ color: 'red', fontWeight: 'bold' }}>{player.score}</span>
        </li>
      ))}
    </ul>
  );
}

export default ScoreBelow70;