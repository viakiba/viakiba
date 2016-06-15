package haust.vk.d_type;

import java.util.Date;

/**
 * @author vk
 *
 * 2016年6月15日
 */
public class User {
	 // 必须给set / get可以不用给
	
	//数据 的封装
	private String name;
	private String pwd;
	private Date brith;
	private int age;
	
	public String getName() {
		return name;
	}
	public String getPwd() {
		return pwd;
	}
	public Date getBrith() {
		return brith;
	}
	public int getAge() {
		return age;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setBrith(Date brith) {
		this.brith = brith;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
