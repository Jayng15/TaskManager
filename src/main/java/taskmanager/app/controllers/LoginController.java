package taskmanager.app.controllers;

import taskmanager.app.templates.*;
import taskmanager.app.entities.*;
import taskmanager.app.managers.*;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.JOptionPane;


public class LoginController {
    public static UserManager userManager = new UserManager();


    public static void show() {
        User user1 = new User("vu123", "12345678");
        User user2 = new User("hai123", "12345678");
        User user3 = new User("trung123", "12345678");
        User user4 = new User("hieu123", "12345678");
        
        // userManager.add(user1);
        // userManager.add(user2);
        // userManager.add(user3);
        // userManager.add(user4);

        String folderDirectory = "C:/Users/jayng/Desktop/Education/study/College/Java Programming/Assignments/taskmanager/src/main/java/taskmanager/app/resources/";

        for (User u: userManager.getAll()) {
            // System.out.println(u.getUserId());
            String userDir = folderDirectory + u.getUserId();
            // folderDirectory += u.getUserId();
            File selectedFolder = new File(userDir);
            loadFilesFromFolder(selectedFolder, u);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });

    }

    public static void login(String username, char[] password) {
        String sPassword = new String(password);
        for (User u: userManager.getAll())
        {
            if(u.getUsername().equals(username) && u.getPassword().equals(sPassword))
            {
                JOptionPane.showMessageDialog(null,"Sucessfully");
                HomePageController.show(u);
                return;
            }
        }
        throw new IllegalArgumentException("Wrong username or password");
    
    }

    private static void loadFilesFromFolder(File folder, User user) {
        if (folder != null && folder.isDirectory()) {
            System.out.println(folder + " " + user.toString());
            File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            if (files != null) {
                for (File file : files) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        StringBuilder deadLine = new StringBuilder();
                        StringBuilder content = new StringBuilder();
                        StringBuilder title = new StringBuilder();
                        StringBuilder companions = new StringBuilder();
                        StringBuilder status = new StringBuilder();
                        deadLine.append(reader.readLine());
                        
                        Date deadLineDate = dateFormat.parse(deadLine.toString());

                        companions.append(reader.readLine());
                        String[] compArray = companions.toString().trim().split("\\s+");
                        ArrayList<String> compList = new ArrayList<>();
                        compList.addAll(Arrays.asList(compArray));
                        status.append(reader.readLine());

                        title.append(reader.readLine());

                        while ((line = reader.readLine()) != null) {
                            content.append(line).append("\n");
                        }
                        Task task = new Task(title.toString(), content.toString(),deadLineDate ,user);
                        task.setCompleted(status.toString());
                        for (String s: compList) {
                            // System.out.println(s);
                            if (!user.getUsername().equals(s))
                            {
                                task.addCompanion(s);    
                            }
                        }
                        user.addTask(task);

                    } catch (IOException e) {
                        // e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error reading file: " + file.getName(), "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        return;
                    }
                }
            }
        }
    }
}
