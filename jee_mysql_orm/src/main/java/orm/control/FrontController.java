package orm.control;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import orm.db.Database;
import orm.dao.TodoNoteDAO;
import orm.model.TodoNote;

/**
 * Servlet using a DAO Service
 * 
 * *** NOTHING TO DO HERE ***
 *
 * @author hajo
 */
@WebServlet(name = "FrontController", urlPatterns = {"/fc"})
public class FrontController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        switch (action) {
            case "add":
                add(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            default: ;
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        TodoNoteDAO dao = Database.INSTANCE.getTodoNoteDAO();

        String text = req.getParameter("text");
        Date dateTime = new Date();
        dao.add(new TodoNote(text, dateTime));
        // PRG because this is a POST
        resp.sendRedirect("/jee_orm/list.jsp");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        TodoNoteDAO dao = Database.INSTANCE.getTodoNoteDAO();
        String id = req.getParameter("id");
        dao.delete(Long.valueOf(id));
        resp.sendRedirect("/jee_orm/list.jsp");
    }

}
