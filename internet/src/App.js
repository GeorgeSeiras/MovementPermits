import './App.css';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";
import React from 'react';
import createPermit from "./components/createPermit";
import viewPermits from "./components/viewPermits";
import viewPermit from "./components/viewPermit";
import Login from "./components/login";
import Token from "./components/token";


function App() {

  const { token, setToken } = Token();

  if (!token) {
    return <Login setToken={setToken} />
  }

  return (
    <main>
      <div className="wrapper">
        <Router>
          <Switch>
            <Route exact path="/login"> <Login /> </Route>
            <Route exact path={["/","/permits"]}> <viewPermits /> </Route>
            <Route exact path="/permits/create"> <createPermit /> </Route>
            <Route exact path="/permits/:id"> <viewPermit /> </Route>
          </Switch>
        </Router>
      </div>
    </main>
  )
}


export default App;
