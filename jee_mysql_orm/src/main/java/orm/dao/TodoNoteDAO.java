package orm.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import orm.model.TodoNote;
import javax.persistence.EntityManagerFactory;
import orm.db.AbstractDAO;
//import orm.model.QTodoNote;

/**
 * DAO for Todo's
 * @author hajo
 */
public class TodoNoteDAO extends AbstractDAO<TodoNote, Long> {

    public TodoNoteDAO(EntityManagerFactory emf) {
        super(emf, TodoNote.class);
    }
 
     
    public void doSomeQuery() {
        //QTodoNote note = QTodoNote.todoNote;
        JPAQueryFactory cf = new JPAQueryFactory(getEntityManager());
        
        // TODO 
    }
    
}
