package BBL.CustomerBusiness;

import Models.Customer;

import java.util.List;

public interface CustomerBusiness {
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer getCustomerById(int id);
    List<Customer> getAllCustomers();
    void createCustomerFromRest(REST.representation.Customer customer);
    List<REST.representation.Customer> getAllCustomersToRest();
}
