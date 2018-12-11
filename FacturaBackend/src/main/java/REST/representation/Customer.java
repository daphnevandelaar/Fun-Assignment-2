package REST.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Customer {
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;

    private java.lang.String id;
    private java.lang.String firstname;
    private java.lang.String lastname;
    private java.lang.String streetname;
    private java.lang.String housenumber;
    private java.lang.String address;
    private java.lang.String place;
    private java.lang.String phonenumber;
    private java.lang.String email;

    public java.lang.String getId() {
        return id;
    }
    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.lang.String getFirstname() {
        return firstname;
    }
    public void setFirstname(java.lang.String firstname) {
        this.firstname = firstname;
    }

    public java.lang.String getLastname() {
        return lastname;
    }
    public void setLastname(java.lang.String lastname) {
        this.lastname = lastname;
    }
    //TODO: nettermaken
    public String getAddress() {
        return streetname;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public java.lang.String getStreetname() {
        return streetname;
    }
    public void setStreetname(java.lang.String streetname) {
        this.streetname = streetname;
    }

    public java.lang.String getHousenumber() {
        return housenumber;
    }
    public void setHousenumber(java.lang.String housenumber) {
        this.housenumber = housenumber;
    }

    public java.lang.String getPlace() {
        return place;
    }
    public void setPlace(java.lang.String place) {
        this.place = place;
    }

    public java.lang.String getEmail() {
        return email;
    }
    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(java.lang.String phonenumber) {
        this.phonenumber = phonenumber;
    }

}
