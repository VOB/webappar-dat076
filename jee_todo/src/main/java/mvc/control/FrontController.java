/*
     Control part of application
 */
package mvc.control;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Model;
import mvc.model.TodoNote;
import mvc.model.User;


/**
 *
 * @author hajo
 */
@WebServlet(name = "FrontController", urlPatterns = {"/fc"})
public class FrontController extends HttpServlet {
    
    private static final Logger LOG = Logger.getAnonymousLogger();
    private static final Level I = Level.INFO;
    
    // TODO A lot. Handle all incomming POST's
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        LOG.log(I, "Action {0}", action);
        String name;
        String email;
        String pwd;
                
        switch (action) {
            case "add":
                String text = req.getParameter("text");
                Model.INSTANCE.getList().add(new TodoNote(text));
                resp.sendRedirect("/todo/list.jsp");
                break;
            case "delete":
                Long id = Long.parseLong(req.getParameter("id"));
                Model.INSTANCE.getList().delete(id);
                resp.sendRedirect("/todo/list.jsp");
                break;
            case "login":
                email = req.getParameter("email");
                pwd = req.getParameter("password");
                User ussr = Model.INSTANCE.login(email, pwd);
                
                if (ussr == null) {
                    resp.sendRedirect("/todo/todo.jsp");
                } 
                else {
                    HttpSession session = req.getSession();
                    session.setAttribute("username", ussr.getName());//resp.setAttribute("username", ussr.getName());
                    resp.sendRedirect("/todo/list.jsp");
                }
                break;
            case "register":
                name = req.getParameter("name");
                email = req.getParameter("email");
                pwd = req.getParameter("password");
                
                Model.INSTANCE.register(name, pwd, email); //TODO
                resp.sendRedirect("/todo/todo.jsp");
                break;
            default: ;
        }
         // PRG pattern
        
    }
    
    
    
    
}
