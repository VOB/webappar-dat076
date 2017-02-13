package todo.ctrl;

import todo.viewmodel.NoteDetailBB;
import todo.core.TodoList;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import static java.util.logging.Logger.*;
import static java.util.logging.Level.*;
import todo.core.TodoNote;
/**
 * Control bean for detail page
 * Execute business logic and return navigation outcome
 *
 *  *** NOTHING TO DO HERE 
 * 
 * @author hajo
 */
@Named("notectrl")
@RequestScoped
public class TodoCtrl implements Serializable {
   
    private TodoList list;
    private NoteDetailBB note;

    @PostConstruct
    public void post() {
        log("NoteCtrl alive " + this);
    }

    @PreDestroy
    public void pre() {
        log("NoteCtrl to be destroyed" + this);
    }

    @Inject
    public void setTodoList(TodoList list) {
        this.list = list;
    }
    
    @Inject
    public void setNoteDetail(NoteDetailBB note) {
        this.note = note;
    }
   
    public String save() {
        log("Save: " + note);
        list.add(new TodoNote(note.getText()));
        return "list?faces-redirect=true";  
    }
   
    public String update() {
        log("Update: " + note);
        list.update(new TodoNote(note.getText()));
        return "list?faces-redirect=true"; 
    }

    public String delete() {
        log("Delete: " + note);
        list.delete(note.getId());
        return "list?faces-redirect=true";
    }
    
    private void log( String message ){
        getAnonymousLogger().log(INFO, message);
    }
    
}
