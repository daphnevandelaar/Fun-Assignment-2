package REST.resource.server;

import BBL.TaskBusiness.TaskBusiness;
import BBL.TaskBusiness.TaskBusinessImplementation;
import REST.representation.Customer;
import REST.representation.Task;
import REST.resource.TasksResource;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;

import java.util.List;
import java.util.logging.Level;

public class TasksServerResource extends AbstractServerResource implements TasksResource {

    TaskBusiness taskBusiness = new TaskBusinessImplementation();

    // Define allowed roles for the method "get".
    private static final String[] get1AllowedGroups = new String[] {"anyone"};
    // Define denied roles for the method "get".
    private static final String[] get1DeniedGroups = new String[] {};

    @Override
    public List<Task> represent() throws Exception {
        List<Task> result = null;
        checkGroups(get1AllowedGroups, get1DeniedGroups);


        try {

            // Query parameters

            result = taskBusiness.getAllTasksToRest();

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
