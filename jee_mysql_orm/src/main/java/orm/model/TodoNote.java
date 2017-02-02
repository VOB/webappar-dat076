package orm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Simple mapping of one table
 *
 * NOTE: Mapping gets much more complex if using more tables and relationships
 * (1:1, 1:M, M:1, M:N)
 *
 * @author hajo
 */


// TODO Make this an Entity class
//@Entity
public class TodoNote implements Serializable {

    private static final long serialVersionUID = 1L;
   
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false, unique = true)
    private Long id;
//    @Column(name = "text")
    private String text;
//    @Column(name = "datetime")
    private Date dateTime;
//    @Column(name = "done")
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
