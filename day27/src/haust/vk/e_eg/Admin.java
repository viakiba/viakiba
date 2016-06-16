package haust.vk.e_eg;

import haust.vk.utils.Column;
import haust.vk.utils.Id;
import haust.vk.utils.Table;

/**
 * @author vk
 *
 * 2016年5月13日
 */

//Admin=a_admin
@Table(tableName="a_admin")
public class Admin {
	
	@Id
	@Column(columnName="a_id")
	private int id;
	
	@Column(columnName = "a_userName")
	private String userName;
	
	@Column(columnName = "a_pwd")
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
		return "Admin [id=" + id + ", pwd=" + pwd + ", userName=" + userName
				+ "]";
	}
}
