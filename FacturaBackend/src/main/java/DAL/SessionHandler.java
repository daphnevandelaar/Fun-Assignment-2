package DAL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.*;

public class SessionHandler {

    @PersistenceContext
    private Session currentSession;
    private Transaction currentTransaction;
    private SessionFactory sessionFactory;

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        if(currentSession == null){
            currentSession = getSessionFactory().openSession();
        }
        currentTransaction = currentSession.beginTransaction();

        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public SessionFactory getSessionFactory() {
        EntityManagerFactory emf = HibernateUtility.getSessionFactory();
        if(sessionFactory == null){
            sessionFactory = emf.unwrap(SessionFactory.class);
        }
        return sessionFactory;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

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
