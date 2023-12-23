package taskmanager.app.entities;


import taskmanager.app.managers.*;
import java.time.*;
import java.util.*;
import javax.swing.*;

public class Task {

    protected LocalDateTime createdDate;
    protected String title;
    protected String description;
    protected boolean completed;
    // protected Date activeDate;
    protected int id;
    protected int author;
    protected TaskManager taskManager;
    // private UserManager userManager;

    // Constructor
    public Task(String title, String description) {
        this.createdDate = LocalDateTime.now();
        setTitle(title);
        this.description = description;
        // this.completed = completed;
        // setActiveDate(activeDate);
        // this.author = author;

        // this.id = id;
    }

    // Getter and Setter methods
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        if (title == null)
        {
            JOptionPane.showMessageDialog(null, "Title cannot be empty");
            throw new IllegalArgumentException();
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

    public int getId()
    {
        return this.id;
    }

    public User getAuthor(UserManager users)
    {
       return users.findById(author);
    }
    

}

