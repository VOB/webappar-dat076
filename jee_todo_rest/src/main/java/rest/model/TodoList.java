package rest.model;

import java.io.Serializable;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import javax.inject.Singleton;

/**
 * Emulating a OO - model of a TODO list
 *
 *    NOTHING TO DO HERE
 * 
 * @author hajo
 */
@Singleton
public class TodoList implements Serializable {

    private final List<TodoNote> notes = new ArrayList<>();

    public TodoList() {
        // Test data
        notes.add(new TodoNote(1L, "Äta gröt"));
        notes.add(new TodoNote(2L, "Rensa sallad"));
        notes.add(new TodoNote(3L, "Jaga älg"));
    }
    
    // Tomcat 8 doesn't support Java 8
    public List<TodoNote> getNotes() {
        /*Collections.sort(notes, (n1, n2) -> {
            return n1.getId() < n1.getId() ? -1 : Objects.equals(n1.getId(), n2.getId()) ? 0 : 1;
        });*/
        Collections.sort(notes, new Comparator<TodoNote>() {
            @Override
            public int compare(TodoNote t1, TodoNote t2) {
                return t1.getId() < t2.getId() ? -1
                        : Objects.equals(t1.getId(), t2.getId()) ? 0 : 1;
            }

        });
        System.out.println(notes);
        return notes;
    }

    public TodoNote getById(Long id) {
        /*Optional<TodoNote> n = notes.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();
        return n.orElse(null);
         */
        for (TodoNote t : notes) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    public void create(TodoNote note) {
        out.println("Create " + note);
        if (!notes.contains(note)) {
            notes.add(note);
        }
    }

    public void update(TodoNote note) {
        out.println("Update " + note);
        TodoNote n = delete(note.getId());
        note.setId(n.getId());
        note.setDateTime(n.getDateTime());
        create(note);
    }

    public TodoNote delete(Long id) {
        TodoNote n = getById(id);
        notes.remove(n);
        return n;
    }

    public int size() {
        return notes.size();
    }
}
