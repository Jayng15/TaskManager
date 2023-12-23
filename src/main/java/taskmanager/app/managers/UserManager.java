package taskmanager.app.managers;

import taskmanager.app.entities.*;

import java.util.ArrayList;
import java.util.List;

public class UserManager implements Manager<User> {

    private static List<User> userList; 

    public UserManager() {
        this.userList = new ArrayList<>();
    }

    @Override
    public void add(User user) {
        userList.add(user);
    }

    @Override
    public void remove(User user) {
        userList.remove(user);
    }

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public User findById(int id) {
        if (!userList.isEmpty()) {
            return userList.get(0);
        }
        return null;
    }
}

