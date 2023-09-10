import './App.css';
import { useState } from "react";
import Login  from "./components/login.component"
import React, { Component } from "react";


function App() {
  
  return (
    <div>
        <h1>Welcome to My App</h1>
        <Login /> {/* Render your login component here */}
      </div>
    
  );
}

export default App;
