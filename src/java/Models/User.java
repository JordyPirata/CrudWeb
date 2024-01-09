package Models;
public class User {
    private int id;
    private String Username;
    private String Password;
    public User() {
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public String getUsername() {
        return Username;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public String getPassword() {
        return Password;
    }
}