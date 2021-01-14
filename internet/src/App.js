import './App.css';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";
import createPermit from "./components/createPermit";
import viewPermits from "./components/viewPermits";
import viewPermit from "./components/viewPermit";
function App() {
  return (
    <main>
      <Router>
        <Switch>
          <Route exact path="/permits" component={viewPermits} />
          <Route path="/permits/create" component={createPermit} />
          <Route path="/permits/:id" component={viewPermit} />
          <Route component={Error} />
        </Switch>
      </Router>
    </main>
  )
}


export default App;
