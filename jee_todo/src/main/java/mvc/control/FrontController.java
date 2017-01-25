/*
     Control part of application
 */
package mvc.control;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author hajo
 */
@WebServlet(name = "FrontController", urlPatterns = {"/fc"})
public class FrontController extends HttpServlet {
    
    private static final Logger LOG = Logger.getAnonymousLogger();
    private static final Level I = Level.INFO;
    
    // TODO A lot. Handle all incomming POST's
    
    
    
    
}
