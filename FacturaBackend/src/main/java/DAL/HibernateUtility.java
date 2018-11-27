package DAL;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

    public static SessionFactory factory;

    private HibernateUtility() {
    }

    public static synchronized SessionFactory getSessionFactory(){
        //Hibernate SessionFactory object as singleton
        if(factory == null)
            factory = new Configuration().configure().buildSessionFactory();
        return factory;
    }

}
