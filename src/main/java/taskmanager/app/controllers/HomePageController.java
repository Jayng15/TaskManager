package taskmanager.app.controllers;

import java.util.*;
import taskmanager.app.entities.*;
import taskmanager.app.entities.User;
import taskmanager.app.templates.HomePage;
import taskmanager.app.templates.LoginForm;

public class HomePageController {
    // private static User userSession;
    public static void show(User user) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage(user).setVisible(true);
            }
        });
    }

    // public static list<String> getTaskTitle() {
        // java
    // }
}
