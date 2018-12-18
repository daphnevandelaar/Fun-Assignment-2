package REST.resource.server;

import BBL.InvoiceBusiness.InvoiceBusiness;
import BBL.InvoiceBusiness.InvoiceBusinessImplementation;
import DAL.CustomerDAL.CustomerService;
import DAL.InvoiceDAL.InvoiceService;
import Factory.InvoiceFactory;
import Factory.TaskFactory;
import Models.Task;
import REST.representation.Customer;
import REST.representation.Invoice;
import REST.resource.InvoiceResource;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

public class InvoiceServerResource extends AbstractServerResource implements InvoiceResource {

    InvoiceBusiness invoiceBusiness = new InvoiceBusinessImplementation();

    // Define allowed roles for the method "get".
    private static final String[] get1AllowedGroups = new String[] {"anyone"};
    // Define denied roles for the method "get".
    private static final String[] get1DeniedGroups = new String[] {};

    public List<Models.Invoice> represent() throws Exception {
        List<Models.Invoice> result = null;
        checkGroups(get1AllowedGroups, get1DeniedGroups);

        try {

            // Query parameters


            result = invoiceBusiness.getAllInvoices();


            // Initialize here your bean
        } catch (Exception ex) {
            // In a real code, customize handling for each type of exception
            getLogger().log(Level.WARNING, "Error when executing the method", ex);
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL,
                    ex.getMessage(), ex);
        }

        return result;
    }

    // Define allowed roles for the method "post".
    private static final String[] post3AllowedGroups = new String[] {"anyone"};
    // Define denied roles for the method "post".
    private static final String[] post3DeniedGroups = new String[] {};

    public void add(Models.Invoice bean) throws Exception {
        checkGroups(post3AllowedGroups, post3DeniedGroups);

        System.out.println(bean.getCustomer().getCustomerid() + " " + bean.getTasks().size() );

        if (bean==null) {
            throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST);
        }

        //TODO: if cus id doesnt exist error..
        CustomerService customerService = new CustomerService();
        Models.Customer cus = customerService.read(bean.getCustomer().getCustomerid());

        Models.Invoice invoice = InvoiceFactory.createInvoice();
        invoice.setCustomer(cus);
        invoice.setTasks(bean.getTasks());
        invoice.setTotalprice(bean.getTotalprice());

        invoiceBusiness.createInvoice(invoice);


        try {
        } catch (Exception ex) {
            // In a real code, customize handling for each type of exception
            getLogger().log(Level.WARNING, "Error when executing the method", ex);
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL,
                    ex.getMessage(), ex);
        }
    }

}
