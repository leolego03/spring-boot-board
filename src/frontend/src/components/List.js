import { Link } from 'react-router-dom'

const List = ({ articles }) => {
  return (
    <table>
      <tbody>
        {articles.map(article => {
          return (
            <tr key={article.id}>
              <td className='subject'>
                <Link to = {`/view/${article.id}`}>{article.subject}</Link>
              </td>
              <td>{article.name}</td>
              <td>
                {article.date.substring(5)}
              </td>
            </tr>
          );
        })}
      </tbody>
    </table>
  )
}

export default List