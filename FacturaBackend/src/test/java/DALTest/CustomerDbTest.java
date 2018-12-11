package DALTest;

import DAL.CustomerDAL.CustomerService;
import DAL.Factory.CustomerFactory;
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
                   "1234TS",
                   "someren",
                   "tester@email.nl",
                   "Testplace"
           );
    }

    @Test
    public void createCustomer(){
        customerService.create(testCustomer);
        Assert.assertEquals(1, testCustomer.getCustomerid());
    }

    @Test
    public void readCustomer(){
        Customer customer = customerService.read(1);
        Assert.assertEquals(1, customer.getCustomerid());
    }
}
