package haust.vk.entity;

/**
 * Created by viakiba on 2017/5/30.
 */
public class User {
    private String age;
    private String username;

    public void setAge(String age) {
        this.age = age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", age=" + age + "]";
    }
}
