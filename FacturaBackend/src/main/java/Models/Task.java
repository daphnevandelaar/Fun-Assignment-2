package Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Task {
    private int taskid;
    private String description;
    private BigDecimal amount; //amount per hour or piece that's because it's a bigdecimal
    private BigDecimal price;
    private Set<Invoice> invoices;

    public Task() {

    }

    @Id
    @GeneratedValue
    public int getTaskid() {
        return taskid;
    }
    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

//    @ManyToMany(mappedBy = "tasks")
//    public Set<Invoice> getInvoices() {
//        return invoices;
//    }
//    public void setInvoices(Set<Invoice> invoices) {
//        this.invoices = invoices;
//    }

}
