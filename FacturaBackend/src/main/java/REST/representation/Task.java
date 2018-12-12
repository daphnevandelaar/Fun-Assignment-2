package REST.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Task {
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;

    private java.lang.String id;
    private java.lang.String description;
    private java.lang.String price;

    public java.lang.String getId() {
        return id;
    }
    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.lang.String getDescription() {
        return description;
    }
    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    public java.lang.String getPrice() {
        return price;
    }
    public void setPrice(java.lang.String price) {
        this.price = price;
    }

}
