package haust.vk.entity;

/**
 * Created by viakiba on 2016/8/17.
 */
public class Admin {
    private int id;
    private String adminName;
    private String pwd;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }
}

