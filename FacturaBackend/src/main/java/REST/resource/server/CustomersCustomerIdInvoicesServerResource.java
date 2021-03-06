package REST.resource.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import REST.representation.Customer;
import REST.resource.CustomersCustomerIdInvoicesResource;
import REST.utils.PathVariableUtils;
import org.restlet.data.Reference;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.data.Preference;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.EmptyRepresentation;
import org.restlet.representation.ObjectRepresentation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import org.restlet.util.Series;
import java.util.logging.Level;

public class CustomersCustomerIdInvoicesServerResource extends AbstractServerResource implements CustomersCustomerIdInvoicesResource {

    // Define allowed roles for the method "get".
    private static final String[] get6AllowedGroups = new String[] {"anyone"};
    // Define denied roles for the method "get".
    private static final String[] get6DeniedGroups = new String[] {};

    public Customer represent() throws Exception {
       Customer result = null;
        checkGroups(get6AllowedGroups, get6DeniedGroups);
        

        try {
		
			// Path variables
			
	    String customerIdPathVariable = Reference.decode(getAttribute("customerId"));
	    PathVariableUtils.checkLong(customerIdPathVariable);

        // Query parameters
        
        	
	    result = new Customer();
	    
	    // Initialize here your bean
         } catch (Exception ex) {
            // In a real code, customize handling for each type of exception
            getLogger().log(Level.WARNING, "Error when executing the method", ex);
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL,
                    ex.getMessage(), ex);
        }
    
        return result;
    }


}

