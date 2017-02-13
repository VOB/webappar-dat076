package todo.viewmodel;

import todo.core.TodoNote;
import todo.core.TodoList;
import java.io.Serializable;
import java.util.Collection;
import javax.faces.view.ViewScoped;  // NOTE : NOT beans.ViewScoped; 
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;

/**
 Backing bean for list.xhtml
 *** NOTHING TO DO HERE 
 Using View scoped because of AJAX calls (i.e. same page, else
 navigation data lost)

 @author hajo
 */
@Named("noteslist")
@ViewScoped
public class NotesListBB implements Serializable {

   
    private TodoList list;
    @Getter
    private int currentPage;
    private int pageSize = 5; // Only read this
   
    protected NotesListBB() {
        // Must have for CDI
    }

    @Inject
    public void setTodoList(TodoList list) {
        this.list = list;
    }

    public Collection<TodoNote> getList() {
        return list.findRange(pageSize * currentPage, pageSize);
    }

    public void next() {
        if (list.size() / pageSize > currentPage) {
            currentPage++;
        }
    }

    public void prev() {
        if (currentPage > 0) {
            currentPage--;
        }
    }    
    
}
