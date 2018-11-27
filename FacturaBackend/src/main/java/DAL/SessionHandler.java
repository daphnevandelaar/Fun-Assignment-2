package DAL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.EntityManagerFactory;

public class SessionHandler {

    private Session currentSession;
    private Transaction currentTransaction;


    public Session getCurrentSession(){

        if(currentSession == null){
            currentSession = HibernateUtility.getSessionFactory().openSession();
        }

        return currentSession;
    }

    public void databaseInteractionWithTransaction(){
        try{
            if(currentSession == null){
                currentSession = HibernateUtility.getSessionFactory().openSession();
            }
            currentTransaction = currentSession.beginTransaction();

        }
        catch (Exception e){
            if(currentTransaction != null){
                currentTransaction.rollback();
            }
        }
        finally {
            currentTransaction.commit();
            currentSession.close();
        }
    }



}
