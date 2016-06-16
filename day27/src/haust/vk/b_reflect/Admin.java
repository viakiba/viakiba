package haust.vk.b_reflect;

/**
 * @author vk
 *
 * 2016年5月11日
 */
public class Admin {
	private int id;
	private String userName;
	private String pwd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", userName=" + userName + ", pwd=" + pwd
				+ "]"  +"\n";
	}
	
}
