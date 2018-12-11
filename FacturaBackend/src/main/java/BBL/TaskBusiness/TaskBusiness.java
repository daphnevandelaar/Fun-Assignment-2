package BBL.TaskBusiness;

import Models.Task;

import java.util.List;

public interface TaskBusiness {
    List<Task> getAllTasks();
    List<REST.representation.Task> getAllTasksToRest();
}
