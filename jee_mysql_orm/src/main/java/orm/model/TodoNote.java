package orm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Simple mapping of one table
 *
 * NOTE: Mapping gets much more complex if using more tables and relationships
 * (1:1, 1:M, M:1, M:N)
 *
 * @author hajo
 */


// TODO Make this an Entity class
public class TodoNote implements Serializable {

    private static final long serialVersionUID = 1L;
   
    private Long id;
    private String text;
    private Date dateTime;
    private boolean done;

    // MUST have
    protected TodoNote(){      
    }
    
    public TodoNote(String text, Date dateTime) {
        this.text = text;
        this.dateTime = dateTime;
        this.done = false;
    }

    @Override
    public String toString() {
        return "TodoNote{" + "id=" + id + ", text=" + text + ", "
                + "dateTime=" + dateTime + ", done=" + done + '}';
    }

}
