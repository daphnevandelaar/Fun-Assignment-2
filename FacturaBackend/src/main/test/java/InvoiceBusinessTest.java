import BBL.InvoiceBusiness.InvoiceBusiness;
import BBL.InvoiceBusiness.InvoiceBusinessImplementation;
import DAL.CustomerDAL.CustomerService;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InvoiceBusinessTest {
    InvoiceBusiness invoiceBusiness = new InvoiceBusinessImplementation();
    SessionHandler dbHandler = new SessionHandler();

    @Before
    public void objectCreation(){
        Customer customer = CustomerFactory.createCustomer();
        customer.setFirstname("Eefje");
        customer.setLastname("Eeverdingen");
        customer.setEmail("eefje1@test.nl");
        customer.setAddress("Straatnaam 1");
        customer.setPlace("Eindhoven");
        customer.setPhonenumber("+3161234567");
        Customer customer1 = CustomerFactory.createCustomer();
        customer1.setFirstname("Twan");
        customer1.setLastname("Tweerden");
        customer1.setEmail("twan2@test.nl");
        customer1.setAddress("NaamStraat 2");
        customer1.setPlace("Tilburg");
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

        Customer customerTest = CustomerFactory.createCustomer();
        customer.setFirstname("Test Customer");

        Task taskTest = TaskFactory.createTask();
        task.setDescription("Test Task");

        Set<Task> tasks = new HashSet<>();
        tasks.add(taskTest);

        mInvoice = InvoiceFactory.createInvoice();
        mInvoice.setInvoiceid(1);
        mInvoice.setCustomer(customerTest);
        mInvoice.setTasks(tasks);
        mInvoice.setTotalprice(new BigDecimal(10.00));

        rInvoice = new REST.representation.Invoice();
        rInvoice.setInvoiceid(2);
        rInvoice.setCustomer(customer);
        rInvoice.setTasks(tasks);
        rInvoice.setTotalprice(new BigDecimal(12.00));

        Invoice invoice = InvoiceFactory.createInvoice();
        invoice.setCustomer(customer);
        invoice.setTotalprice(new BigDecimal(123.02));

        dbHandler.openCurrentSessionwithTransaction();
        dbHandler.getCurrentSession().persist(customer);
        dbHandler.getCurrentSession().persist(customer1);
        dbHandler.getCurrentSession().persist(task);
        dbHandler.getCurrentSession().persist(task1);
        dbHandler.getCurrentSession().persist(task2);
        dbHandler.getCurrentSession().persist(invoice);
        dbHandler.closeCurrentSessionwithTransaction();

    }

    Invoice mInvoice;
    REST.representation.Invoice rInvoice;

    @Test
    public void testB_toRestObject(){
        REST.representation.Invoice rInv = invoiceBusiness.toRestObject(mInvoice);
        Assert.assertEquals(rInv.getInvoiceid(), mInvoice.getInvoiceid());
        Assert.assertEquals(rInv.getCustomer(), mInvoice.getCustomer());
        Assert.assertEquals(rInv.getTasks(), mInvoice.getTasks());
        Assert.assertEquals(rInv.getTotalprice(), mInvoice.getTotalprice());
    }

    @Test
    public void testC_readInvoices_Successfull(){
        List<Invoice> invoices = invoiceBusiness.getAllInvoices();

        Assert.assertEquals(2, invoices.size());
    }
    @Test
    public void testC_readRestInvoices_Successfull(){
        List<REST.representation.Invoice> invoices = invoiceBusiness.getAllRestInvoices();

        Assert.assertEquals(3, invoices.size());
    }

    @Test
    public void TestD_createInvoice_Successfull(){
        CustomerService customerService = new CustomerService();
        TaskService taskService = new TaskService();

        Invoice invoice = InvoiceFactory.createInvoice();
        Customer customer = customerService.read(1);
        invoice.setCustomer(customer);
        invoice.setTotalprice(new BigDecimal(7382.21));
        invoice.setTotalpriceInclTax(new BigDecimal(12.33*1.21));

        Task task = taskService.read(3);
        System.out.println(task.getDescription());
        Set<Task> tasks = new HashSet<Task>();
        tasks.add(taskService.read(3));
        tasks.add(taskService.read(4));
        invoice.setTasks(tasks);

        invoiceBusiness.createInvoice(invoice);
    }
}
