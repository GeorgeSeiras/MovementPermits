import './App.css';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";
import React from 'react';
import CreatePermit from "./components/createPermit";
import ViewPermits from "./components/viewPermits";
import ViewPermit from "./components/viewPermit";
import Login from "./components/login";
import Header from "./components/header";
import Token from './components/token';

function App() {

  const { token, setToken } = Token();
  if(!token) {
    return <Login setToken={setToken} />
  }

  return (
    <main>
      <div className="wrapper">
        <Header/>
        <Router>
          <Switch>
            <Route exact path={["/","/permits"]}> <ViewPermits/> </Route>
            <Route exact path="/permits/create"> <CreatePermit /> </Route>
            <Route exact path="/permits/:id"> <ViewPermit /> </Route>
          </Switch>
        </Router>
      </div>
    </main>
  )
}


export default App;
