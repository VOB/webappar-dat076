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
        User tmp = new User("tmp", passwd, email);
        User real = reg.lookup(tmp);
        
        if (real != null && passwd.equals(real.getPassword())) {
            return real;
        }
       
        return null;
    }

    public User register(String name, String password, String email) {
        
        User newUser = new User(name, password, email);
        
        if (reg.lookup(newUser) == null) {
            reg.register(newUser);
            return newUser;
        }
        
        return null;
    }

}
