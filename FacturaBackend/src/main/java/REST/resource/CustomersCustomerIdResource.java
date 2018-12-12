package REST.resource;

import REST.representation.Customer;
import org.restlet.resource.Get;
import org.restlet.resource.Delete;
import org.restlet.resource.Options;
import org.restlet.representation.Representation;
public interface CustomersCustomerIdResource {

    @Get
    Customer represent() throws Exception;

    @Delete
    void remove() throws Exception;

}

