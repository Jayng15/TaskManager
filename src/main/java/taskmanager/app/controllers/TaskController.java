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

    public static ArrayList<String> getTeammate(Task task) {
        ArrayList<String> usernames = new ArrayList<>();
        for(User u: task.getAllCompanions())
        {
            if (u.getUsername().length() < 20)
            {
                usernames.add(u.getUsername());
            }
            else 
            {
                usernames.add(u.getUsername().substring(0, 17) + "...");
            }
        }
        return usernames;
    }

    public static ArrayList<String> getAssignedTaskTitle(User user) {
        List<Task> tasks = user.getAssignedTasks();
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
