package haust.vk.entity;

/**
 * Created by viakiba on 2017/5/16.
 */
public class User {
    private String username;
    private String age;
    public User() {
        super();
    }
    public User(String username, String age) {
        super();
        this.username = username;
        this.age = age;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "User [username=" + username + ", age=" + age + "]";
    }
}
