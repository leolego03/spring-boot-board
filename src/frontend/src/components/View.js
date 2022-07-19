import { Link,
          useLocation } from 'react-router-dom'

const View = () => {
  const location = useLocation()
  const data = location.state.data

  return (
    <div className="App-view">
      <div>
        <p>{data.subject}</p>
        <span>{data.name}</span>
        <span>{data.date.substring(5)}</span>
      </div>

      <div>
        {data.content}
      </div>

      <Link to='/'>Go Back</Link>
    </div>
  )
}

export default View