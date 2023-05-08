
import './App.css';
import Register from "./components/Register";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Login from "./components/Login";

import Student from "./components/Student";

function App() {
  return (
      <div>
        <BrowserRouter>
          <Routes>
            <Route path="/students" element= { <Student/>} />
            <Route path="/register" element= { <Register/>} />
            <Route path="/" element= { <Login/>} />
          </Routes>
        </BrowserRouter>

      </div>
  );
}

export default App;
