package orm.db;

import orm.dao.TodoNoteDAO;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * Need this because other objects are created for page, request, session ,etc..
 * 
 * *** NOTHING TO DO HERE ***
 */
public enum Database {
    INSTANCE;

    public TodoNoteDAO getTodoNoteDAO() {
        return dao;
    }

    private final EntityManagerFactory emf = Persistence.
            createEntityManagerFactory("todo_pu");
    // Possibly all DAOs share same factory.
    private final TodoNoteDAO dao = new TodoNoteDAO(emf);
}
