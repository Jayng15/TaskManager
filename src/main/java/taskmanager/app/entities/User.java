package taskmanager.app.entities;

import java.util.*;

import taskmanager.app.controllers.LoginController;
import taskmanager.app.managers.UserManager;
public class User {
    private int userId;    
    private String username;
    private String password;
    private List<Task> ownedTasks;
    private List<Task> assignedTasks;
    private UserManager userManager;
    

    public User(String username, String password)
    {
        // this.userId = userId;
        this.username = username;  
        this.password = password;
        this.ownedTasks = new ArrayList<>();
        this.assignedTasks = new ArrayList<>();
        setUserId();
        // this.userId = userManager.findById()
    }

    // Getter and setter methods

    public int getUserId() {
        return this.userId;
    }

    public void setUserId() {
        List<User> users = LoginController.userManager.getAll();
        for (User u: users)
        {
            if (this.username == u.getUsername())
            {
                this.userId = users.indexOf(u);
                return;
            }
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        // return this.password;

    }

    public List<Task> getOwnTasks() {
        return ownedTasks;
    }

    public void addTask(Task task) {
        this.ownedTasks.add(task);
    }

    public void removeTask(Task task){
        if (task != null) {
            this.ownedTasks.remove(task);
        }
    }

    public List<Task> getAssignedTasks() {
        return this.assignedTasks;
    }

    public void assignTask(Task task) {
        if (task != null)
        {
            this.assignedTasks.add(task);
            return;
        }
        return;
    }

}


