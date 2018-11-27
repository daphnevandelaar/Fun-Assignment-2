import DAL.HibernateUtility;
import DAL.SessionHandler;
import Factory.CustomerFactory;
import Models.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerDatabaseTest {
    SessionHandler dbHandler = new SessionHandler();

    Customer customer;
    Customer customer1;
    Customer customer2;
    Customer customer3;

    @Before
    public void testCustomers(){
        customer = CustomerFactory.createCustomer();
        customer.setFirstname("Eefje");
        customer.setLastname("Eerste klant");
        customer.setEmail("eefje1@test.nl");
        customer.setAddress("Straatnaam 1");
        customer.setPlace("Eindhoven");
        customer.setPhonenumber("+3161234567");
        customer1 = CustomerFactory.createCustomer();
        customer1.setFirstname("Twan");
        customer1.setLastname("Tweede klant");
        customer1.setEmail("twan2@test.nl");
        customer1.setAddress("NaamStraat 2");
        customer1.setPlace("Tilburg");
        customer1.setPhonenumber("+3167654321");
        customer2 = CustomerFactory.createCustomer();
        customer2.setFirstname("Dennie");
        customer2.setLastname("Derde klant");
        customer2.setEmail("dennie3@test.nl");
        customer2.setAddress("Stranaamat 3");
        customer2.setPlace("Den Bosch");
        customer2.setPhonenumber("+3164567123");
        customer3 = CustomerFactory.createCustomer();
        customer3.setFirstname("Veronica");
        customer3.setLastname("Vierde klant");
        customer3.setEmail("veronica4@test.nl");
        customer3.setAddress("Maantaarts 4");
        customer3.setPlace("Vlierden");
        customer3.setPhonenumber("+3161237654");
    }

    @Test
    public void testA_createCustomer_Successfull(){
        dbHandler.getCurrentSession().persist(customer);
        dbHandler.getCurrentSession().persist(customer1);
        dbHandler.getCurrentSession().persist(customer2);
        dbHandler.getCurrentSession().persist(customer3);
        dbHandler.databaseInteractionWithTransaction();
    }

    @Test
    public void testB_readCustomers_Successfull(){
        List<Customer> customers = dbHandler.getCurrentSession().createQuery("FROM Customer", Customer.class).list();
        System.out.println(customers.size());
        Assert.assertEquals(4, customers.size());
    }

    @Test
    public void testC_readCustomer_ById_Successfull(){
        Customer foundCustomer = dbHandler.getCurrentSession().get(Customer.class, 1);
        Assert.assertEquals("Eefje", foundCustomer.getFirstname());
    }

    @Test
    public void testD_readCustomers_OtherWay_Successfull(){
        SessionHandler handler = new SessionHandler();
        CriteriaBuilder criteriaBuilder = handler.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        criteriaQuery.from(Customer.class);
        List<Customer> cussies = handler.getCurrentSession().createQuery(criteriaQuery).getResultList();
        System.out.println(cussies.size());
    }

    @Test
    public void testE_updateCustomers_Successfull(){
        customer3.setLastname("Updated with test name");
        customer3.setCustomerid(3);
        dbHandler.getCurrentSession().update(customer3);
        dbHandler.databaseInteractionWithTransaction();
    }

    @Test
    public void testF_deleteCustomer_Successful(){
        customer3.setCustomerid(3);
        dbHandler.getCurrentSession().delete(customer3);
        dbHandler.databaseInteractionWithTransaction();
    }
}
