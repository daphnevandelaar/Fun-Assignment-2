package REST.resource;

import REST.representation.Customer;
import org.restlet.resource.Get;
import org.restlet.resource.Options;
import org.restlet.representation.Representation;
public interface CustomersCustomerIdInvoicesResource {

    @Get
    Customer represent() throws Exception;

}

