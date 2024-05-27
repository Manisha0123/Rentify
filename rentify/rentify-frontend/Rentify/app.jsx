import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Home from './components/home';
import Login from './components/login';
import Register from './components/register';
import PropertyList from './components/propertyList';
import PropertyForm from './components/propertyForm';
import PropertyDetails from './components/propertyDetails';

function App() {
  return (
    <Router>
      <div>
        <Switch>
          <Route path="/login" component={Login} />
          <Route path="/register" component={Register} />
          <Route path="/properties/new" component={PropertyForm} />
          <Route path="/properties/:id" component={PropertyDetails} />
          <Route path="/properties" component={PropertyList} />
          <Route path="/" exact component={Home} />
        </Switch>
      </div>
    </Router>
  );
}

export default App;

