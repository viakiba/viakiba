package haust.vk.a_validation;

import java.util.Date;

/**
 * @author vk
 *
 * 2016年6月17日
 */
public class User {
	private String userName;
	private String pwd;
	private String email;
	private Date birth;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", pwd=" + pwd + ", email="
				+ email + ", birth=" + birth + "]";
	}
	
	
}
