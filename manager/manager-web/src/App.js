import React from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Home from './components/Home';
import Oracle from './components/Oracle';

const App = () => {
  return (
    <>
      <Router>
        <Switch>
          <Route path="/oracle">
            <Oracle />
          </Route>
          <Route path="/" exact>
            <Home />
          </Route>
        </Switch>
      </Router>
    </>
  );
};

export default App;
