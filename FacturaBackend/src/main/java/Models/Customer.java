package Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Customer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {
    private int customerid;
    private String firstname;
    private String lastname;
    private String address;     //street + housenumber
    private String street;
    private String housenumber;
    private String zipcode;
    private String place;
    private String email;
    private String phonenumber;
    private Set<Invoice> invoices;

    public Customer() {
    }

    public Customer(int customerid, String firstname, String lastname, String street, String housenumber, String zipcode, String place, String email, String phonenumber, Set<Invoice> invoices) {
        this.customerid = customerid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = street + housenumber;
        this.street = street;
        this.housenumber = housenumber;
        this.zipcode = zipcode;
        this.place = place;
        this.email = email;
        this.phonenumber = phonenumber;
        this.invoices = invoices;
    }

    @Id
    @GeneratedValue
    public int getCustomerid() {
        return customerid;
    }
    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    //TODO: create address from street + housenumber
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

//    public String getStreet() {
//        return street;
//    }
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    public String getHousenumber() {
//        return housenumber;
//    }
//    public void setHousenumber(String housenumber) {
//        this.housenumber = housenumber;
//    }

    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

}
