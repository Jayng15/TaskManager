package taskmanager.app.entities;

import java.util.*;
public class User {
    private int userId;    
    private String username;
    private String password;
    private List<Task> ownedTasks;
    private List<Target> ownedTargets;

    public User(String username, String password)
    {
        // this.userId = userId;
        this.username = username;  
        this.password = password;
        this.ownedTasks = new ArrayList<>();
        this.ownedTargets = new ArrayList<>();
    }

    // Getter and setter methods

    public int getUserId() {
        return userId;
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

    public List<Target> getOwnTargets() {
        return ownedTargets;
    }

    public void addTarget(Target target) {
        this.ownedTargets.add(target);
    }

}


