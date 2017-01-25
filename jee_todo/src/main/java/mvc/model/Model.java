package mvc.model;

/**
 * Singleton to access the model parts of application
 *
 * @author hajo
 */
public enum Model {
    INSTANCE;

    private final TodoList list = new TodoList();
    private final UserRegistry reg = new UserRegistry();

    public TodoList getList() {
        return list;
    }

    public UserRegistry getUserRegistry() {
        return reg;
    }

    
    public User login(String email, String passwd) {
        
        // TODO
       
        return null;
    }

    public User register(String name, String password, String email) {
        
        // TODO
       
        return null;
    }

}
