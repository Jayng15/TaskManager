package taskmanager.app.entities;


import taskmanager.app.controllers.LoginController;
import taskmanager.app.managers.*;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import javax.swing.*;

public class Task {

    protected Date createdDate;
    protected Date deadLine;
    protected String title;
    protected String description;
    protected boolean completed;
    // protected Date activeDate;
    // protected int id;
    // protected int author;
    protected TaskManager taskManager;
    protected UserManager userManager;
    private List<User> companions;
    // private UserManager userManager;

    // Constructor
    public Task(String title, String description, Date deadLine, User author) {
        this.createdDate = new Date();
        setTitle(title);
        setDescription(description);
        setDeadLine(deadLine);
        setCompleted(false);
        companions = new ArrayList<>();
        companions.add(author);
        // this.description = description;
        // this.completed = completed;
        // setActiveDate(activeDate);
        // this.author = author;

        // this.id = id;
    }

    // public Task() {
    // }

    // Getter and Setter methods
    public Date getCreatedDate() {
        return createdDate;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDeadLine(Date time) {
        if (time.before(createdDate) || time.equals(createdDate))
        {
            throw new IllegalArgumentException("Deadline cannot be in the past");
        }
        this.deadLine = time;
    }

    public void setTitle(String title) {
        if (title.equals(null))
        {
            throw new IllegalArgumentException("Title cannot be null");
        }
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    
    public String getCompleted() {
        Date date = new Date();
        if (this.completed == false && this.deadLine.before(date))
        {
            return "outdated";
        }

        if (this.completed == false)
        {
            return "pending";
        }

        return "finished";

    }

    public String getDeadline() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(this.deadLine);

        return date;
    }

    // public Date getActiveDate() {
    //     return activeDate;
    // }

    // public void setActiveDate(Date activeDate) {
    //     if (activeDate == null)
    //     {
    //         JOptionPane.showMessageDialog(null, "Active date cannot be empty");
    //         throw new IllegalArgumentException();
    //     }
    //     // this.activeDate = activeDate;
    // }

    // public int getId()
    // {
    //     return this.id;
    // }

    // public User getAuthor(UserManager users)
    // {
    //    return users.findById(author);
    // }
    

    public void addCompanion(String username, Task task) {
        User user; 
        UserManager users = LoginController.userManager;
        for (User u: users.getAll())
        {
            if (u.getUsername().equals(username))
            {
                this.companions.add(u);
                u.assignTask(task);
                return;
            }
        }
        throw new IllegalArgumentException("Cannot find the specified user");

    }

    public void removeCompanion(User user) {
        this.companions.remove(user);
    }

    public List<User> getAllCompanions() {
        return this.companions;
    }


}

