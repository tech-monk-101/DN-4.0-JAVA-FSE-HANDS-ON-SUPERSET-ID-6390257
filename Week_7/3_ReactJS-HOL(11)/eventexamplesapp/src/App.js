import { useState } from "react";

function App() {
  const [ele, update] = useState(1);
  const inc = () => {
    update(ele + 1);
    alert("Hello Cognizant!");
  }
  const dec = () => {
    update(ele - 1);
  }
  const wel = () => {
    alert("Welcome!");
  }
  const pre = () => {
    alert("I Was Clicked");
  }

  const [euroAmt, setEuroAmount] = useState('');
  const [rupeeAmt, setRupeesAmount] = useState(0);

  const rate = 80;

  const handleSubmit = (e) => {
    e.preventDefault();
    const amt = parseFloat(euroAmt);
    if (!isNaN(amt)) {
      const output = amt * rate;
      setRupeesAmount(output);
      alert(`Converted Amount: ₹ ${output}`);
    } else {
      setRupeesAmount(0);
      alert('Please enter a valid number.');
    }
  };
  return (
    <div className="App">
      <p>{ele}</p>
        <button onClick={inc}>
        Increment
      </button>
      <button onClick={dec}>
        Decrement
      </button>
      <button onClick={wel}>
        Say Welcome
      </button>
      <button onClick={pre}>
        Click Me
      </button>

      <h2>Currency Converter</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Amount (EUR):
          <input
            type="number"
            value={euroAmt}
            onChange={(e) => setEuroAmount(e.target.value)}
          />
        </label>
        <button type="submit">Convert</button>
      </form>
    </div>
  );
}

export default App;
