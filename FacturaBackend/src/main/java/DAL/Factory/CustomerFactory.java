package DAL.Factory;

import Models.Customer;
import Models.Invoice;

import java.util.Set;

public class CustomerFactory {

    private static Customer create(){
        return new Customer();
    }
    public static Customer create(int customerid,
                                  String firstname,
                                  String lastname,
                                  String street,
                                  String housenumber,
                                  String zipcode,
                                  String place,
                                  String email,
                                  String phonenumber,
                                  Set<Invoice> invoices){
        Customer c = create();
        c.setCustomerid(customerid);
        c.setFirstname(firstname);
        c.setLastname(lastname);
        c.setStreet(street);
        c.setHousenumber(housenumber);
        c.setZipcode(zipcode);
        c.setPlace(place);
        c.setEmail(email);
        c.setPhonenumber(phonenumber);
        c.setInvoices(invoices);
        return c;
    }
}
