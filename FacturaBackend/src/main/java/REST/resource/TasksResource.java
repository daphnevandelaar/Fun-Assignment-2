package REST.resource;

import REST.representation.Task;
import org.restlet.resource.Get;

import java.util.List;

public interface TasksResource {
    @Get
    List<Task> represent() throws Exception;
}
