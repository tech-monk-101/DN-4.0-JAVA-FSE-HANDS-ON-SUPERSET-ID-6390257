import React, { useState } from 'react';

function GuestPage() {
  return (
    <div>
      <h1>Please Sign Up.</h1>
    </div>
  );
}

function UserPage() {
  return (
    <div>
      <h1>Welcome Back</h1>
    </div>
  );
}

function LoginButton(props) {
  return (
    <button onClick={props.onClick}>
      Login
    </button>
  );
}

function LogoutButton(props) {
  return (
    <button onClick={props.onClick}>
      Logout
    </button>
  );
}

export default function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => {
    setIsLoggedIn(true);
  };

  const handleLogout = () => {
    setIsLoggedIn(false);
  };

  return (
    <div >
      {isLoggedIn ? <UserPage /> : <GuestPage />}
      <div>
        {isLoggedIn ? (
          <LogoutButton onClick={handleLogout} />
        ) : (
          <LoginButton onClick={handleLogin} />
        )}
      </div>
    </div>
  );
}
