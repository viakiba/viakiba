package haust.vk.entity;

/**
 * @author vk
 *
 * 2016年6月16日
 */
public class Admin {
	private String userName;
	private int id;
	private String pwd;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		System.out.println("实例化对象");
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
