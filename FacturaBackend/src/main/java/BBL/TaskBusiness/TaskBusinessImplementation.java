package BBL.TaskBusiness;

import DAL.TaskDAL.TaskService;
import Models.Task;
import REST.representation.Customer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TaskBusinessImplementation implements TaskBusiness{
    private TaskService taskService = new TaskService();

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<Models.Task>(taskService.readAll());
    }

    public List<REST.representation.Task> getAllTasksToRest() {
        List<Task> modelTasks = new ArrayList<>();
        modelTasks.addAll(taskService.readAll());

        List<REST.representation.Task> restTasks = new ArrayList<>();

        for (Task task : modelTasks) {
            restTasks.add(modelTaskToRestTask(task));
        }

        return restTasks;
    }

    private REST.representation.Task modelTaskToRestTask(Models.Task mTask){
        REST.representation.Task restTask = new REST.representation.Task();

        restTask.setId(Integer.toString(mTask.getTaskid()));
        restTask.setDescription(mTask.getDescription());
        restTask.setPrice(mTask.getPrice().toString());

        return restTask;
    }
}
