package DALTest;

import DAL.Factory.CustomerFactory;
import DAL.Services.CustomerService;
import Models.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerDbTest {
    private CustomerService customerService = new CustomerService();

    private Customer testCustomer;

    @Before
    public void beforeTest(){
           testCustomer = CustomerFactory.create(
                   1,
                   "Test",
                   "Customer",
                   "Teststreet",
                   "25",
                   "1234TT",
                   "Testplace",
                   "tester@test.com",
                   "0612345678",
                   null
           );
    }

    @Test
    public void createCustomer(){
        customerService.create(testCustomer);
        Assert.assertEquals(1, testCustomer.getCustomerid());
    }

    @Test
    public void readCustomer(){
        Customer customer = customerService.readById(1);
        Assert.assertEquals(1, customer.getCustomerid());
    }
}
