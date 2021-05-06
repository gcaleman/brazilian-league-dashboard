import './App.css';
import { TeamDetailPage } from './pages/TeamDetailPage';
import { TeamPage } from './pages/TeamPage';
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import { SeasonDetailPage } from './pages/SeasonDetailPage';
import { GameDetailPage } from './pages/GameDetailPage';
import { NavigationBar } from './components/NavigationBar';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Footer } from './components/Footer';


function App() {
  return (
    <div className="App">
        <Router>
          <NavigationBar />
        </Router>
      <Switch>
        <Route path="/" exact component={TeamPage} />
        <Route path='/team/:handle'>
          <TeamDetailPage />
        </Route>
        <Route path='/season/:teamName/:season'>
          <SeasonDetailPage />
        </Route>
        <Route path='/match/:home/:away/:gameSeason'>
          <GameDetailPage />
        </Route>
      </Switch>
      <Footer />
    </div>
  );
}

export default App;
