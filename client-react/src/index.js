import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import './index.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import App from './App';
import Authenticate from './pages/Authenticate';
import Register from './pages/Register';
import Workspace from './pages/Workspace';
import Customer from './pages/Customer';
import Maintenance from './pages/Maintenance';
import NotFound from "./pages/NotFound";
import Legal from './pages/Legal';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route index element={<App/>} />
        <Route path="authenticate" element={<Authenticate/>} />
        <Route path="register" element={<Register/>} />
        <Route path="legal" element={<Legal/>} />
        <Route path="workspace" element={<Workspace/>} />
        <Route path="customer" element={<Customer/>} />
        <Route path="maintenance" element={<Maintenance/>} />
        <Route path="*" element={<NotFound/>} />
      </Routes>
    </BrowserRouter>
  </React.StrictMode>
);

reportWebVitals();
