package taskmanager.app.managers;

import taskmanager.app.entities.*;
import java.util.*;
import java.time.*;

public class NoteManager implements Manager<Note> {
    private List<Note> notes;

    public NoteManager() {
        notes = new ArrayList<>();
    }

    @Override
    public void add(Note note)
    {
        notes.add(note);
    }

    @Override
    public void remove(Note note)
    {
        for (Note n : notes)
        {
            if (n == note)
            {
                notes.remove(note);
            }
        }
    }

    @Override
    public List<Note> getAll()
    {
        return notes;
    }

    @Override
    public Note findById(int id)
    {
        return notes.get(id);
    }


    
}
