import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Navigation from '../components/Navigation';
import {Dashboard} from "../components/Dashboard";

function Workspace(){
  
  const navigate = useNavigate();
  
  useEffect(() => {
    const authenticated = localStorage.getItem("authenticated");
    if(!authenticated){
      navigate("/authenticate");
    }
  },[]);

  return (
    <div className="App">
      <Navigation></Navigation>
      <Dashboard></Dashboard>
    </div>
  );
}

export default Workspace;