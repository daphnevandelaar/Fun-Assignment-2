package REST.resource;

import REST.representation.Customer;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.Post;

import java.util.List;

public interface CustomersResource {

    @Get
    List<Customer> represent() throws Exception;

    @Put
    Customer store() throws Exception;

    @Post
    void add(Customer bean) throws Exception;

}

