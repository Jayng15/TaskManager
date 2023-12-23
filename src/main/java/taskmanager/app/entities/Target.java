package taskmanager.app.entities;

import java.util.*;
import javax.swing.*;
import java.time.*;

public class Target extends Task {
    private LocalDateTime finishDate;

    public Target(String title, String description, LocalDateTime finishDate) {
        super(title, description); 
        setFinishDate(finishDate); 
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }
    
    public void setFinishDate(LocalDateTime finishDate) {
        if (finishDate == null) {
            JOptionPane.showMessageDialog(null, "Finish Date cannot be empty");
            throw new IllegalArgumentException();
        }
        else if (finishDate.isBefore(LocalDateTime.now()))
        {
            JOptionPane.showMessageDialog(null, "Finish Date cannot be in the past");
            throw new IllegalArgumentException();
        }
        this.finishDate = finishDate;
    }
}

