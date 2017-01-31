package orm.beans;

import java.util.List;
import orm.db.Database;
import orm.dao.TodoNoteDAO;
import orm.model.TodoNote;


/**
 *    *** NOTHING TO DO HERE ***
 * 
 * Data for JSP pages (an instance of this class i used in the JSP page)
 * @author hajo
 */
public class ViewModel {
       
    // This only lives for requests
    public  List<TodoNote> getNotes(){
        return Database.INSTANCE.getTodoNoteDAO().get();
    }
    
     public TodoNote getById(String id) {
        TodoNoteDAO dao = Database.INSTANCE.getTodoNoteDAO();
        return dao.getById(Long.valueOf(id));
     }
}
