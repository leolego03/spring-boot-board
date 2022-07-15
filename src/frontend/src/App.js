import logo from './logo.svg';
import './App.css';
import React, {useEffect, useState} from 'react';
import axios from 'axios';

function App() {
  const [articles, setArticles] = useState([])

  useEffect(() => {
    axios.get('/api/v1/article')
    .then(response => setArticles(response.data))
    .catch(error => console.log(error))
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>

        {articles.map(article => {
          return (
            <ul key={article.id}>
              <li>{article.name}</li>
              <li>{article.subject}</li>
              <li>{article.content}</li>
              <li>{article.date}</li>
            </ul>
          );
        })}

      </header>
    </div>
  );
}

export default App;
