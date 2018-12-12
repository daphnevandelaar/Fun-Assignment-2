package Factory;

import Models.Task;

public class TaskFactory {
    public static Task createTask(){
        return new Task();
    }

}
