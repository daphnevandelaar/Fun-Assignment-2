package REST.representation;

import Models.Customer;
import Models.Task;

import java.math.BigDecimal;
import java.util.Set;


public class Invoice {
    private static final long serialVersionUID = 1L;

    private int invoiceid;
    private Customer customer;
    private Set<Task> tasks;
    private BigDecimal totalprice;
    private BigDecimal totalpriceInclTax;

    public Invoice() {

    }

    public int getInvoiceid() {
        return this.invoiceid;
    }
    public void setInvoiceid(int invoiceid) {
        this.invoiceid = invoiceid;
    }


    public Customer getCustomer() {
        return this.customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Task> getTasks() {
        return this.tasks;
    }
    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public BigDecimal getTotalprice() {
        return this.totalprice;
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
