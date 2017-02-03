package rest.resources;

import com.google.gson.Gson;
import rest.model.TodoList;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;

/**
 * REST Web Service
 *
 * @author hajo
 */
@Path("list")
public class TodoListResource {

    private static final Logger LOG = Logger.getLogger(TodoListResource.class.getName());

    @Context
    private UriInfo uriInfo;
   
    @Inject
    private TodoList list;
    private final Gson gson = new Gson();

    // TODO Add rest methods
}
