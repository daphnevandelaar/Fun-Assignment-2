package REST.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Invoice {
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;

    private java.lang.String id;
    private java.lang.String Customer;
    private java.lang.String totalPrice;
    private java.lang.String date;
    private java.util.List<java.lang.String> Tasks;

    public java.lang.String getId() {
        return id;
    }
    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.lang.String getCustomer() {
        return Customer;
    }
    public void setCustomer(java.lang.String Customer) {
        this.Customer = Customer;
    }

    public java.lang.String getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(java.lang.String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public java.lang.String getDate() {
        return date;
    }
    public void setDate(java.lang.String date) {
        this.date = date;
    }
    
    public java.util.List<java.lang.String> getTasks() {
        if (Tasks == null) {
            Tasks = new ArrayList<java.lang.String>();
        }
        return Tasks;
    }
    public void setTasks(java.util.List<java.lang.String> Tasks) {
        this.Tasks = Tasks;
    }

}
