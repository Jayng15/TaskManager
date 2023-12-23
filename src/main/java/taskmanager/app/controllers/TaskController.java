package taskmanager.app.controllers;

import taskmanager.app.entities.*;
import java.util.*;
public class TaskController {
    public static ArrayList<String> getTaskTitle(User user) {
        List<Task> tasks = user.getOwnTasks();
        ArrayList<String> titles = new ArrayList<>();
        for(Task t: tasks)
        {
            titles.add(t.getTitle());
        }
        return titles;
        
    }
}
