package DAL;

import javax.persistence.TypedQuery;

public class HibernateQueryHandler {

//    public List<Author> getAuthorsByLastName(String lastName) {
//        String queryString = "SELECT a FROM Author a " +
//                "WHERE a.lastName IS NULL OR LOWER(a.lastName) = LOWER(:lastName)";
//
//        TypedQuery<Author> query = getEntityManager().createQuery(queryString, Author.class);
//        query.setParameter("lastName", lastName);
//        return query.getResultList();
//    }
//
//    protected void ExecuteProcedure(TypedQuery<Object> hQuery, IEnumerable<SqlParameter> procedureParameters)
//    {
//
//
//        using (var sqlConnection = new SqlConnection(ConnectionString))
//        using (var command = new SqlCommand(procedureQuery, sqlConnection))
//        {
//            command.CommandType = CommandType.StoredProcedure;
//
//            if (procedureParameters != null)
//            {
//                command.Parameters.AddRange(procedureParameters.ToArray());
//            }
//
//            sqlConnection.Open();
//            command.ExecuteNonQuery();
//            sqlConnection.Close();
//        }
//    }
}
