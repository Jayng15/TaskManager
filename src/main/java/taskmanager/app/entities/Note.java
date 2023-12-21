package taskmanager.app.entities;

import java.util.*;
import java.time.*;
import javax.swing.*;

public class Note {
    private LocalDateTime createdDate;
    private String title;
    private String description;

    public Note(String title, String description) {
        this.createdDate = LocalDateTime.now();
        setTitle(title);
        this.description = description;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setTitle(String title) {
        if (title == null) {
            JOptionPane.showMessageDialog(null,"Title cannot be empty");
            throw new IllegalArgumentException();
        }
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    } 
}
