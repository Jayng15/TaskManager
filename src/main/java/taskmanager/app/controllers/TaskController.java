package taskmanager.app.controllers;

import taskmanager.app.entities.*;

import java.text.SimpleDateFormat;
import java.util.*;
public class TaskController {
    public static ArrayList<String> getTaskTitle(User user) {
        List<Task> tasks = user.getOwnTasks();
        ArrayList<String> titles = new ArrayList<>();
        // SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for(Task t: tasks)
        {
            if (t.getTitle().length() < 25)
            {
                titles.add(t.getTitle() + " " + t.getDeadline());
            }
            else 
            {
                titles.add(t.getTitle().substring(0, 23) + "..." + " " + t.getDeadline());
            }
        }
        return titles;
        
    }
}
