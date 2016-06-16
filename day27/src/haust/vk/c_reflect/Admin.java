package haust.vk.c_reflect;

/**
 * @author vk
 *
 * 2016年5月12日
 */
public class Admin {
	private int id=1000;
	private String name="张三";
	
	public Admin(){
		System.out.println("Admin.admin()");
	}
	
	public Admin(String name){
		System.out.println("Admin.admin" + name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
