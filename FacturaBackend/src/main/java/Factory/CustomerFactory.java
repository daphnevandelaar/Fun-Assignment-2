package Factory;

import Models.Customer;

public class CustomerFactory {
    public static Customer createCustomer(){
        return new Customer();
    }
}
