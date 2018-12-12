import DAL.CustomerDAL.CustomerService;
import DAL.InvoiceDAL.InvoiceService;
import DAL.SessionHandler;
import DAL.TaskDAL.TaskService;
import Factory.CustomerFactory;
import Factory.InvoiceFactory;
import Factory.TaskFactory;
import Models.Customer;
import Models.Invoice;
import Models.Task;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InvoiceServiceTest {

    InvoiceService invoiceService = new InvoiceService();
    CustomerService customerService = new CustomerService();
    TaskService taskService = new TaskService();
    SessionHandler dbHandler = new SessionHandler();

    //TODO: add tasks with an amount

    @Before
    public void testInvoices(){
        Customer customer = CustomerFactory.createCustomer();
        customer.setFirstname("Eefje");
        customer.setLastname("Eeverdingen");
        customer.setEmail("eefje1@test.nl");
        customer.setAddress("Straatnaam 1");
        customer.setPlace("Eindhoven");
        customer.setPhonenumber("+3161234567");
        customer.setZipcode("1283LK");
        Customer customer1 = CustomerFactory.createCustomer();
        customer1.setFirstname("Twan");
        customer1.setLastname("Tweerden");
        customer1.setEmail("twan2@test.nl");
        customer1.setAddress("NaamStraat 2");
        customer1.setPlace("Tilburg");
        customer1.setZipcode("5622CK");
        customer1.setPhonenumber("+3167654321");

        Task task = TaskFactory.createTask();
        task.setDescription("Maïs Hakselen");
        task.setPrice(new BigDecimal(50.60));
        Task task1 = TaskFactory.createTask();
        task1.setDescription("Container Transport");
        task1.setPrice(new BigDecimal(30.75));
        Task task2 = TaskFactory.createTask();
        task2.setDescription("Balen Persen");
        task2.setPrice(new BigDecimal(12.80));

        dbHandler.openCurrentSessionwithTransaction();
        dbHandler.getCurrentSession().persist(customer);
        dbHandler.getCurrentSession().persist(customer1);
        dbHandler.getCurrentSession().persist(task);
        dbHandler.getCurrentSession().persist(task1);
        dbHandler.getCurrentSession().persist(task2);
        dbHandler.closeCurrentSessionwithTransaction();
    }

    @Test
    public void testA_createInvoice_Successfull(){
        Invoice invoice = InvoiceFactory.createInvoice();
        Customer customer = customerService.read(1);
        invoice.setCustomer(customer);
        invoice.setTotalprice(new BigDecimal(12.333));
        invoice.setTotalpriceInclTax(new BigDecimal(12.33*1.21));

        Task task = taskService.read(3);
        System.out.println(task.getDescription());
        Set<Task> tasks = new HashSet<Task>();
        tasks.add(taskService.read(3));
        tasks.add(taskService.read(4));
        invoice.setTasks(tasks);

        invoiceService.create(invoice);
    }

    @Test
    public void testB_readInvoices_Successfull() {
        List<Invoice> invoices = new ArrayList<>(invoiceService.readAll());
        System.out.println(invoices.size());
        Assert.assertEquals(1, invoices.size());
    }

    @Test
    public void testC_readInvoiceById_Successfull(){
        Invoice inv =  invoiceService.read(6);
        System.out.println(inv.getInvoiceid());
        Assert.assertEquals(6, inv.getInvoiceid());
        Assert.assertEquals(new BigDecimal(12.33), inv.getTotalprice());
        Assert.assertEquals(1, inv.getCustomer().getCustomerid());
        Assert.assertEquals("Eefje", inv.getCustomer().getFirstname());
    }
}
