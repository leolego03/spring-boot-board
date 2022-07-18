const List = ({ articles }) => {
  return (
    <table>
      <tbody>
        {articles.map(article => {
          return (
            <tr key={article.id}>
              <td>
                <a href={`/view`}>{article.subject}</a>
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