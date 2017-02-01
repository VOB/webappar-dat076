package mvc.beans;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mvc.model.Model;
import mvc.model.TodoNote;

/**
 * Data for JSP pages (an instance of this class i used in the JSP page)
 * 
 * ***  NOTHING TO DO HERE ***
 * 
 * @author hajo
 */

public class ViewModel {
   private static final Logger LOG = Logger.getLogger(ViewModel.class.getName());
    
    // TODO Supply data to JSP pages
   public List<TodoNote> getList () {
       LOG.log(Level.INFO, "tjabba");
       return Model.INSTANCE.getList().getNotes();
   }
   
    public TodoNote getById( Long id ){
        return Model.INSTANCE.getList().getById(id);
    }
   
}
