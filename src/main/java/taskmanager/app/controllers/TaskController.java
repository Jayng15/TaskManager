package taskmanager.app.controllers;

import taskmanager.app.entities.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
public class TaskController {
    private static String resourcePath = "C:/Users/jayng/Desktop/Education/study/College/Java Programming/Assignments/taskmanager/src/main/java/taskmanager/app/resources";
    public static ArrayList<String> getTaskTitle(User user) {
        List<Task> tasks = user.getOwnTasks();
        ArrayList<String> titles = new ArrayList<>();
        // SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (Task t : tasks) {
            if (t.getTitle().length() < 25) {
                titles.add(t.getTitle() + " " + t.getDeadline());
            } else {
                titles.add(t.getTitle().substring(0, 23) + "..." + " " + t.getDeadline());
            }
        }
        return titles;

    }

    public static ArrayList<String> getTeammate(Task task) {
        ArrayList<String> usernames = new ArrayList<>();
        for (User u : task.getAllCompanions()) {
            if (u.getUsername().length() < 20) {
                usernames.add(u.getUsername());
            } else {
                usernames.add(u.getUsername().substring(0, 17) + "...");
            }
        }
        return usernames;
    }

    public static ArrayList<String> getAssignedTaskTitle(User user) {
        List<Task> tasks = user.getAssignedTasks();
        ArrayList<String> titles = new ArrayList<>();
        // SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (Task t : tasks) {
            if (t.getTitle().length() < 25) {
                titles.add(t.getTitle() + " " + t.getDeadline());
            } else {
                titles.add(t.getTitle().substring(0, 23) + "..." + " " + t.getDeadline());
            }
        }
        return titles;

    }

    public static void writeTxtFile(Task task, User user, String oldFileName) {

        String destination = resourcePath + File.separator + user.getUserId();
        String fileName = task.getTitle();

        if (fileName != null && !fileName.trim().isEmpty()) {

            String fullFileName = oldFileName != null ? oldFileName + ".txt" : fileName + ".txt";

            File fileToSave = new File(destination, fullFileName);

            File folder = fileToSave.getParentFile();

            if (!folder.exists()) {
                if (folder.mkdirs()) {
                } else
                    return;
            }
            // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                writer.write(task.getDeadline());
                writer.write("\n");
                // if (selectedTaskId != -1) {
                for (User u : task.getAllCompanions()) {
                    writer.write(u.getUsername() + " ");
                }
                writer.write("\n");
                writer.write(task.getCompleted() + "\n");
                // }
                writer.write(task.getTitle());
                writer.write("\n");
                writer.write(task.getDescription());
                JOptionPane.showMessageDialog(null, "File saved successfully!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error saving the file.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if (oldFileName != null) {
                File newFile = new File(destination, fileName + ".txt");
                if (fileToSave.renameTo(newFile)) {
                } else {
                    JOptionPane.showMessageDialog(null, "Can't overwrite the file");
                }
            }

        }

    }

    public static void deleteFile(User user, String fileName) {
        String fullPath = resourcePath + File.separator + user.getUserId() + File.separator + fileName + ".txt";
        File deleteFile = new File(fullPath);

        if (deleteFile.delete()) {
            JOptionPane.showMessageDialog(null, "Delete successfully");
        } else {
            System.out.println(fullPath);
            JOptionPane.showMessageDialog(null, "Cannot delete this file");
            return;
        }
    }

}
