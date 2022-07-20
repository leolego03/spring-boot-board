import React, {useEffect, useState} from 'react';
import axios from 'axios';
import { Link,
          useParams } from 'react-router-dom';

const View = () => {
  const { id } = useParams()

  const [article, setArticle] = useState({})

  useEffect(() => {
    axios.get(`/api/v1/article/${id}`)
    .then(response => setArticle(response.data))
    .catch(error => console.log(error))
  }, [id]);

  return (
    <div className="App-view">
      <div className='view-head'>
        <p>{article.subject}</p>
        
        <div>
          <span>{article.name}</span>
          <span>{article.date?.substring(5)}</span>
        </div>
      </div>

      <div className="view-content">
        {article.content}
      </div>

      <Link to='/'>Go Back</Link>

    </div>
  )
}

export default View