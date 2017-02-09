package rest.resources;

import com.google.gson.Gson;
import java.net.URI;
import java.util.List;
import java.util.logging.Level;
import rest.model.TodoList;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.core.*;
import javax.ws.rs.*;
import rest.model.TodoNote;



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
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public Response findAll() {
        List<TodoNote> notes = list.getNotes();
        return addCORSheaders(Response.ok(gson.toJson(notes))).build();
    }
    
    @GET
    @Path("{id: \\d+}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public Response find(@PathParam("id") Long id) {
        TodoNote n = list.getById(id);
        if (n != null) {
            return addCORSheaders(Response.ok(gson.toJson(n))).build();
        } else {
            return addCORSheaders(Response.status(Response.Status.NOT_FOUND)).build();
        }
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Path("count")
    public Response count() {
        int count = list.size();
        JSONPrimitive<Integer>  p = new JSONPrimitive("count", count);
        return addCORSheaders(Response.ok(gson.toJson(p))).build();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public Response add(@FormParam("name") String name) {
        TodoNote note = new TodoNote(null, name);
        list.create(note);
        URI noteUri = uriInfo
                .getAbsolutePathBuilder()
                .path(String.valueOf(note.getId()))
                .build(note);
        // Set it to 201 (created) and setting response header 'Location'
        // Inspect with cURL
        return addCORSheaders(Response.created(noteUri)).build();
    }

    @DELETE
    @Path("{id: \\d+}")
    public Response delete(@PathParam("id") Long id) {
        // A successful response SHOULD be 200 (OK) if the response 
        // includes an entity describing the status, 202 (Accepted) if 
        // the action has not yet been enacted, or 204 (No Content) if 
        // the action has been enacted but the response does not 
        // include an entity.
        list.delete(id);
        return addCORSheaders(Response.noContent()).build();
    }
    
    @PUT
    @Path("{id: \\d+}")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public Response update(@PathParam("id") Long id,
            @FormParam("name") String name, @FormParam("done") boolean done) {
        TodoNote note = new TodoNote(id, name);
        list.update(note);

        //If an existing resource is modified, either the 200 (OK) or 204 
        //(No Content) response codes > SHOULD be sent to indicate 
        //successful completion of the request.
        return addCORSheaders(Response.ok()).build();
    }

    @OPTIONS
    //@Path("{*}")
    @Path("/{path: .*}")
    public Response options() {
        LOG.log(Level.INFO, "OPTIONS");
        return addCORSheaders(Response.ok()).build();
    }
    ///////////////////////////////////////////////////////////////////////////
    // HELPER FUNCTIONS
    ///////////////////////////////////////////////////////////////////////////
    class JSONPrimitive<T> {
        public String key;
        T value;

        public JSONPrimitive(String key, T value) {
            this.key = key;
            this.value = value;
        }
        
    };
    
    private Response.ResponseBuilder addCORSheaders(Response.ResponseBuilder builder) {
        return builder.header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, PATCH, OPTION, DELETE, PUT")
                .header("Access-Control-Allow-Headers", "X-Requested-With, Content-Type");
    }
}
