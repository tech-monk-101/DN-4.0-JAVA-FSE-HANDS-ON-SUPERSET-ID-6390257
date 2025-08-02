import './App.css';

function App() {
  const element = "Office Space";
  const imag = <img src="/office_space.jpg" width="25%" height="25%" alt="Office Space" />;
  const ItemName = { Name: "DBS", Rent: 50000, Address: "Chennai" };
  let rentColor = ItemName.Rent <= 60000 ? 'red' : 'green';

  return (
    <div className="App">
      <h1>{element}, at Affordable Range</h1>
      {imag}
      <h2>Name: {ItemName.Name}</h2>
      <h3 style={{ color: rentColor }}>Rent: Rs. {ItemName.Rent}</h3>
      <h3>Address: {ItemName.Address}</h3>
    </div>
  );
}

export default App;