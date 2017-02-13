package todo.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * Model object
 *
 * *** NOTHING TO DO HERE 
 * 
 * This will later be handled by the database
 *
 * @author hajo
 */
@Named
@ApplicationScoped
// @Stateless Am EJB (DAO) later
public class TodoList {

    private final List<TodoNote> notes = new ArrayList<>();

    @PostConstruct
    public void post() {
        generateData();
    }

    public void add(TodoNote p) {
        if (!notes.contains(p)) {
            notes.add(p);
        }
    }

    public void update(TodoNote p) {
        TodoNote old = find(p.getId());
        int i = notes.indexOf(old);
        if (i > -1) {
            notes.set(i, p);
        }
    }

    public void delete(Long id) {
        TodoNote p = find(id);
        if (p != null) {
            notes.remove(p);
        }
    }

    public TodoNote find(Long id) {
        for (TodoNote p : notes) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public Collection<TodoNote> findAll() {
        return notes;
    }

    public Collection<TodoNote> findRange(int first, int n) {
        if (first < 0 || notes.size() < first) {
            return new ArrayList<>();
        } else if (first + n < notes.size()) {
            return notes.subList(first, first + n);
        } else {
            return notes.subList(first, notes.size());
        }
    }

    public int size() {
        return notes.size();
    }

    // Emulating a database
    private void generateData() {
        // Test data
        notes.add(new TodoNote(1L, "Äta gröt"));
        notes.add(new TodoNote(2L, "Rensa sallad"));
        notes.add(new TodoNote(3L, "Jaga älg"));
        notes.add(new TodoNote(4L, "Sköta katt"));
        notes.add(new TodoNote(5L, "Skjuta katt"));
        notes.add(new TodoNote(6L, "Laga bil"));
        notes.add(new TodoNote(7L, "Sota spis"));

    }

}
