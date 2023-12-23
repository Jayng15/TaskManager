package taskmanager.app.managers;

import taskmanager.app.entities.*;
import java.util.*;

public interface Manager<T> {

    public void add(T object);

    public void remove(T object);
    
    public List<T> getAll();
    
    public T findById(int id);
}
