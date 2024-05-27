
import React from 'react';
import { Link } from 'react-router-dom';
import './home.css';

const Home = () => {
  return (
    <div className="home">
      <h1>Welcome to Rentify</h1>
      <Link to="/login">Login</Link> | <Link to="/register">Register</Link> | <Link to="/properties">View Properties</Link>
    </div>
  );
};

export default Home;
