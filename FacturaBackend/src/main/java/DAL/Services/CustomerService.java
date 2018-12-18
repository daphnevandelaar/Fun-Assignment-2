package DAL.Services;

import DAL.CustomerDAL.CustomerDAO;
import DAL.CustomerDAL.CustomerDAOImplementation;
import Models.Customer;

import java.util.List;
import java.util.Set;

public class CustomerService implements CustomerDAO {
    private static CustomerDAOImplementation customerDAO;

    public CustomerService() {
        customerDAO = new CustomerDAOImplementation();
    }

    public List<Customer> readByZipcode(String zipcode) {
        return null;
    }

    public void create(Customer entity) {
        customerDAO.openCurrentSessionwithTransaction();
        customerDAO.create(entity);
        customerDAO.closeCurrentSessionwithTransaction();
    }

    @Override
    public Customer read(Integer index) {
        customerDAO.openCurrentSessionwithTransaction();
        Customer customer = customerDAO.read(index);
        customerDAO.closeCurrentSessionwithTransaction();
        return customer;
    }

    public Set<Customer> readAll() {
        customerDAO.openCurrentSessionwithTransaction();
        Set<Customer> customers = customerDAO.readAll();
        customerDAO.closeCurrentSessionwithTransaction();
        return customers;
    }

    public void update(Customer entity) {
        customerDAO.openCurrentSessionwithTransaction();
        customerDAO.update(entity);
        customerDAO.closeCurrentSessionwithTransaction();
    }

    public void delete(Customer entity) {

    }
}
