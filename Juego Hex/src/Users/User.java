package Users;

/**
 *
 * @author Kevin Trejos
 */
public class User {
    
   private String name;
   WriterManagerText writer = new WriterManagerText();
   private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "," + name + "," + writer.getMD5(password) + "\n";
    }
}
