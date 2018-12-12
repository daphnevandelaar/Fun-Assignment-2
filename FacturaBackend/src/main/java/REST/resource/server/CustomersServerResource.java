package REST.resource.server;

import java.util.List;

import BBL.CustomerBusiness.CustomerBusiness;
import BBL.CustomerBusiness.CustomerBusinessImplementation;
import REST.representation.Customer;
import REST.resource.CustomersResource;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;

import java.util.logging.Level;


public class CustomersServerResource extends AbstractServerResource implements CustomersResource {

    CustomerBusiness customerBusiness = new CustomerBusinessImplementation();
    // Define allowed roles for the method "get".
    private static final String[] get1AllowedGroups = new String[] {"anyone"};
    // Define denied roles for the method "get".
    private static final String[] get1DeniedGroups = new String[] {};

    public List<Customer> represent() throws Exception {
       List<Customer> result = null;
        checkGroups(get1AllowedGroups, get1DeniedGroups);
        

        try {
		
            // Query parameters

            result = customerBusiness.getAllCustomersToRest();

            // Initialize here your bean
         } catch (Exception ex) {
            // In a real code, customize handling for each type of exception
            getLogger().log(Level.WARNING, "Error when executing the method", ex);
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL,
                    ex.getMessage(), ex);
        }
    
        return result;
    }

    // Define allowed roles for the method "put".
    private static final String[] put2AllowedGroups = new String[] {"anyone"};
    // Define denied roles for the method "put".
    private static final String[] put2DeniedGroups = new String[] {};

    public Customer store() throws Exception {
       Customer result = null;
        checkGroups(put2AllowedGroups, put2DeniedGroups);
        

        try {
		
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

    // Define allowed roles for the method "post".
    private static final String[] post3AllowedGroups = new String[] {"anyone"};
    // Define denied roles for the method "post".
    private static final String[] post3DeniedGroups = new String[] {};

    public void add(Customer bean) throws Exception {
        checkGroups(post3AllowedGroups, post3DeniedGroups);
        
    	if (bean==null) {
    		throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST);
    	}

    	customerBusiness.createCustomerFromRest(bean);

        try {
         } catch (Exception ex) {
            // In a real code, customize handling for each type of exception
            getLogger().log(Level.WARNING, "Error when executing the method", ex);
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL,
                    ex.getMessage(), ex);
        }
    
        
    }


}

