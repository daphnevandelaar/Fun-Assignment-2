package Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "Invoice")
public class Invoice {
    private int invoiceid;
    private Customer customer;
    private Set<Task> tasks;
    private BigDecimal totalprice;
    private BigDecimal totalpriceInclTax;

    public Invoice() {

    }

    @Id
    @GeneratedValue
    public int getInvoiceid() {
        return invoiceid;
    }
    public void setInvoiceid(int invoiceid) {
        this.invoiceid = invoiceid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerid")
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToMany
    @JoinTable(
            name = "Tasks_Invoice",
            joinColumns = {
                    @JoinColumn(name = "taskid")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "invoiceid")
            }
    )
    public Set<Task> getTasks() {
        return tasks;
    }
    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }
    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public BigDecimal getTotalpriceInclTax() {
        return totalpriceInclTax;
    }
    public void setTotalpriceInclTax(BigDecimal totalpriceInclTax) {
        this.totalpriceInclTax = totalpriceInclTax;
    }

}
