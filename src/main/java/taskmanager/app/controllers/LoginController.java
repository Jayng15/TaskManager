package taskmanager.app.controllers;

import taskmanager.app.templates.*;
import taskmanager.app.entities.*;
import taskmanager.app.managers.*;
import java.util.*;

import javax.swing.JOptionPane;


public class LoginController {
    private static UserManager userManager = new UserManager();


    public static void show() {
        User user1 = new User("vu123", "12345678");
        User user2 = new User("hai123", "12345678");
        User user3 = new User("trung123", "12345678");
        User user4 = new User("hieu123", "12345678");
        
        userManager.add(user1);
        userManager.add(user2);
        userManager.add(user3);
        userManager.add(user4);

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
                break;
            }
            throw new IllegalArgumentException("Wrong username or password");
        }
    
    }
}
