package BBL.CustomerBusiness;

import DAL.CustomerDAL.CustomerService;
import Factory.CustomerFactory;
import Models.Customer;

public class CustomerBusiness {

    public CustomerBusiness() {
    }

    public Customer createCustomer(int id, String firstname, String lastname, String address, String place, String email, String phonenumber){
        Customer customer = CustomerFactory.createCustomer();
        customer.setCustomerid(id);
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setAddress(address);
        customer.setPlace(place);
        customer.setEmail(email);
        customer.setPhonenumber(phonenumber);
        return customer;
    }

    public Customer createCustomer(String firstname, String lastname, String address, String place, String email, String phonenumber){
        Customer customer = CustomerFactory.createCustomer();
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setAddress(address);
        customer.setPlace(place);
        customer.setEmail(email);
        customer.setPhonenumber(phonenumber);
        return customer;
    }

    public void saveCustomerToDB(Customer customer){
        CustomerService customerService = new CustomerService();
        customerService.create(customer);
    }

}
