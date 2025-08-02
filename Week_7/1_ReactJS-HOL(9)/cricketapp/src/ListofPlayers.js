import React from 'react';

function ListofPlayers({ players }) {
  if (!players || players.length === 0) return <p>No players to show</p>;

  return (
    <ul>
      {players.map(item => (
        <li key={item.name}>
          Mr. {item.name}{' '}
          <span style={{ color: item.score < 70 ? 'red' : 'green', fontWeight: 'bold' }}>
            {item.score}
          </span>
        </li>
      ))}
    </ul>
  );
}

export default ListofPlayers;