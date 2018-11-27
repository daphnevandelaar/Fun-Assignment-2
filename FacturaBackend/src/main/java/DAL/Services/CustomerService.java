package DAL.Services;

import DAL.CustomerDAL.CustomerDAO;
import DAL.CustomerDAL.CustomerDAOImplementation;
import Models.Customer;

import java.util.List;

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

    public List<Customer> readAll() {
        customerDAO.openCurrentSessionwithTransaction();
        List<Customer> customers = customerDAO.readAll();
        customerDAO.closeCurrentSessionwithTransaction();
        return customers;
    }

    public Customer readById(Integer id) {
        customerDAO.openCurrentSessionwithTransaction();
        Customer customer = customerDAO.readById(id);
        customerDAO.closeCurrentSessionwithTransaction();
        return customer;
    }

    public void update(Customer entity) {
        customerDAO.openCurrentSessionwithTransaction();
        customerDAO.update(entity);
        customerDAO.closeCurrentSessionwithTransaction();
    }

    public void delete(Customer entity) {

    }
}
