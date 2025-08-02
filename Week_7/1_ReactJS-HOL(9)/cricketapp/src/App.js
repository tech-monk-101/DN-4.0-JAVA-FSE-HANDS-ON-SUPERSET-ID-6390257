import React from 'react';
import ListofPlayers from './ListofPlayers';
import ScoreBelow70 from './ScoreBelow70';
import OddPlayers from './OddPlayers';
import EvenPlayers from './EvenPlayers';
import MergedList from './MergedList';  

const flag = true;

function App() {
  const players = [
    { name: "Sachin", score: 95 },
    { name: "Dhoni", score: 60 },
    { name: "Virat", score: 80 },
    { name: "Rohit", score: 72 },
    { name: "Yuvaraj", score: 66 },
    { name: "Raina", score: 45 },
  ];

  const oddTeam = [players[0].name, players[2].name, players[4].name];
  const evenTeam = [players[1].name, players[3].name, players[5].name];

  const T20Players = ["First Player", "Second Player", "Third Player"];
  const RanjiTrophyPlayers = ["Fourth Player", "Fifth Player", "Sixth Player"];
  const IndianPlayers = [...T20Players, ...RanjiTrophyPlayers];

  return (
    <div>
      {flag ? (
        <>
          <h2>List of Players</h2>
          <ListofPlayers players={players} />

          <h2>List of Players with Scores Less Than 70</h2>
          <ScoreBelow70 players={players} />
        </>
      ) : (
        <>
          <h2>Odd Players</h2>
          <OddPlayers players={oddTeam} />

          <h2>Even Players</h2>
          <EvenPlayers players={evenTeam} />

          <h2>List of Indian Players Merged</h2>
          <MergedList players={IndianPlayers} />
        </>
      )}
    </div>
  );
}

export default App;