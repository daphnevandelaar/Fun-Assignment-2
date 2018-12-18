import BBL.CustomerBusiness.CustomerBusiness;
import BBL.CustomerBusiness.CustomerBusinessImplementation;
import DAL.CustomerDAL.CustomerService;
import Models.Customer;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class CustomerDAOTest {
    CustomerBusiness customerBusiness = new CustomerBusinessImplementation();
    CustomerService customerService = new CustomerService();

    @Test
    public void testGetAllCustomersFromService(){
        Set<Customer> customers = customerService.readAll();
        System.out.println(customers.size());
        System.out.println(customers.toString());
    }

    @Test
    public void testGetAllCustomersFromBusiness(){
        customerBusiness.getAllCustomers();
    }
}
