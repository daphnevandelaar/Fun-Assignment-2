package DAL.CustomerDAL;

import DAL.HibernateUtility;
import Models.Customer;

import java.util.Set;

public class CustomerService implements CustomerDAO {
    private static CustomerDAOImplementation customerDAO;

    public CustomerService() {
        customerDAO = new CustomerDAOImplementation();
    }

    public void create(Customer entity) {
        customerDAO.openCurrentSessionwithTransaction();
        customerDAO.create(entity);
        customerDAO.closeCurrentSessionwithTransaction();
    }

    public Customer read(Integer index) {
        customerDAO.openCurrentSessionwithTransaction();
        Customer customer = customerDAO.read(index);
        customerDAO.closeCurrentSessionwithTransaction();
        return customer;
    }

    public Set<Customer> readAll() {
        try{
            customerDAO.getCurrentSession();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        Set<Customer> customers =customerDAO.readAll();
        return customers;
//        System.out.println("Method adjusted in CustomerService");
//        return customerDAO.readAll();
    }

    public void update(Customer entity) {
        customerDAO.getCurrentSession();
        customerDAO.update(entity);
        customerDAO.databaseInteractionWithTransaction();
    }

    public void delete(Customer entity) {
        customerDAO.getCurrentSession();
        customerDAO.delete(entity);
        customerDAO.databaseInteractionWithTransaction();
    }
}
