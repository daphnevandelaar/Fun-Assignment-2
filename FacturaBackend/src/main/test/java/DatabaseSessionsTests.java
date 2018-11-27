import DAL.SessionHandler;
import Factory.CustomerFactory;
import Models.Customer;
import org.junit.Test;

public class DatabaseSessionsTests {
    SessionHandler handler = new SessionHandler();

    @Test
    public void testConnection(){

        Customer customer1 = CustomerFactory.createCustomer();
        customer1.setFirstname("Eefje");
        Customer customer = CustomerFactory.createCustomer();
        customer.setFirstname("Twan");

        handler.getCurrentSession().persist(customer);
        handler.getCurrentSession().persist(customer1);

        handler.databaseInteractionWithTransaction();

        System.out.println(customer1.getFirstname());
    }

}
