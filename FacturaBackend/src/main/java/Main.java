import Models.Customer;
import Models.Invoice;
import Models.Task;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;

public class Main {

    public static void configuration(){
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Customer.class);
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();

        Task task = new Task();
        task.setDescription("test dienst");

        session.persist(task);
        t.commit();
    }

    public static void main(final String[] args) throws Exception {
        configuration();

    }
}
