package BBL.CustomerBusiness;

import DAL.CustomerDAL.CustomerService;
import Factory.CustomerFactory;
import Models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerBusinessImplementation implements CustomerBusiness{

    private CustomerService customerService = new CustomerService();

    public CustomerBusinessImplementation() {
    }

    public Customer newCustomer(int id, String firstname, String lastname, String address, String place, String email, String phonenumber){
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

    public Customer newCustomer(String firstname, String lastname, String address, String place, String email, String phonenumber){
        Customer customer = CustomerFactory.createCustomer();
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setAddress(address);
        customer.setPlace(place);
        customer.setEmail(email);
        customer.setPhonenumber(phonenumber);
        return customer;
    }

    public void createCustomer(Customer customer) {
        customerService.create(customer);
    }

    public void updateCustomer(Customer customer) {
        customerService.update(customer);
    }

    public void createCustomerFromRest(REST.representation.Customer customer){
       customerService.create(restCustomerToModelCustomer(customer));
    }

    public Customer getCustomerById(int id) {
        return customerService.read(id);
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<Customer>(customerService.readAll());
    }

    public List<REST.representation.Customer> getAllCustomersToRest(){

        List<Customer> modelCustomers = new ArrayList<>();
        modelCustomers.addAll(customerService.readAll());

        List<REST.representation.Customer> restCustomers = new ArrayList<>();

        for (Customer cus : modelCustomers) {
            restCustomers.add(modelCustomerToRestCustomer(cus));
        }
        return restCustomers;
    }

    private Customer restCustomerToModelCustomer(REST.representation.Customer rCus){
        Customer modelCustomer = CustomerFactory.createCustomer();

        if(rCus.getId() != null){
            modelCustomer.setCustomerid(Integer.parseInt(rCus.getId()));
        }
        modelCustomer.setFirstname(rCus.getFirstname());
        modelCustomer.setLastname(rCus.getLastname());
        modelCustomer.setEmail(rCus.getEmail());
        modelCustomer.setPhonenumber(rCus.getPhonenumber());
        modelCustomer.setPlace(rCus.getPlace());
        modelCustomer.setAddress(rCus.getAddress());

        return modelCustomer;
    }

    private REST.representation.Customer modelCustomerToRestCustomer(Models.Customer mCus){
        REST.representation.Customer restCustomer = new REST.representation.Customer();

        restCustomer.setId( Integer.toString(mCus.getCustomerid()));
        restCustomer.setFirstname(mCus.getFirstname());
        restCustomer.setLastname(mCus.getLastname());
        restCustomer.setPlace(mCus.getPlace());
        restCustomer.setStreetname(mCus.getAddress());
        restCustomer.setEmail(mCus.getEmail());
        restCustomer.setPhonenumber(mCus.getPhonenumber());

        return restCustomer;
    }
}
