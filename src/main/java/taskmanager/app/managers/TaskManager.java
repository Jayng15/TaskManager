package taskmanager.app.managers;

import taskmanager.app.entities.*;
import java.util.*;

public class TaskManager implements Manager<Task> {

    protected List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public void add(Task task){
        tasks.add(task);
    }

    @Override
    public void remove(Task task){
        for (Task t: tasks)
        {
            if(t == task)
            {
                this.tasks.remove(task);
            }
        }
    }

    @Override
    public List<Task> getAll()
    {
        return tasks;
    }
    
}
