import logo from './logo.svg';
import './App.css';
import React, {useEffect, useState} from 'react';
import axios from 'axios';
import { BrowserRouter as Router,
          Routes,
          Route } from 'react-router-dom';
import List from './components/List';
import View from './components/View';

function App() {
  const [articles, setArticles] = useState([])

  useEffect(() => {
    axios.get('/api/v1/article')
    .then(response => setArticles(response.data))
    .catch(error => console.log(error))
  }, []);

  return (
    <Router>
      <div className="App">

        <div className="App-list">

          <Routes>
            <Route exact path='/' element={
              <>
                <img src={logo} className="App-logo" alt="logo" />
                <List articles = {articles} />
              </>
            }></Route>
            <Route exact path='/view/:id' element={< View />}></Route>
          </Routes>

        </div>

      </div>
    </Router>
  );
}

export default App;
