package REST.resource;

import REST.representation.Invoice;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

import java.util.List;

public interface InvoiceResource {
    @Get
    List<Models.Invoice> represent() throws Exception;

    @Post
    void add(Models.Invoice bean) throws Exception;
}
