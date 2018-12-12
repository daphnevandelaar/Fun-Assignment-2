package DAL.TaskDAL;

import Models.Customer;
import Models.Task;

import java.util.Set;

public class TaskService implements TaskDAO {
    private static TaskDAOImplementation taskDAO;

    public TaskService() {
        taskDAO = new TaskDAOImplementation();
    }

    @Override
    public void create(Task entity) {
        taskDAO.openCurrentSessionwithTransaction();
        taskDAO.create(entity);
        taskDAO.closeCurrentSessionwithTransaction();
    }

    @Override
    public Task read(Integer index) {
        taskDAO.openCurrentSession();
        Task task = taskDAO.read(index);
        taskDAO.closeCurrentSession();
        return task;
    }

    @Override
    public Set<Task> readAll() {
        try{
            taskDAO.getCurrentSession();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        Set<Task> tasks = taskDAO.readAll();
        taskDAO.databaseInteractionWithTransaction();
        return tasks;
    }

    @Override
    public void update(Task entity) {
        System.out.println("Task update service not implemented");
    }

    @Override
    public void delete(Task entity) {
        System.out.println("Task delete service not implemented");
    }
}
