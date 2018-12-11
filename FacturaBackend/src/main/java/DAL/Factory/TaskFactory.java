package DAL.Factory;

import Models.Task;

public class TaskFactory {
    private static Task create(){
        return new Task();
    }
}
