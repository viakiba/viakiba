package hausrt.vk.a_hello;

public class User {
	private int id;
	private String name;
	
	public User() {
		super();
		System.out.println("------User对象创建------");
	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	public void init_user(){
		System.out.println("创建对象之后，初始化");
	}
	
	public void destory_user(){
		System.out.println("IOC容器销毁，user对象初始化");
	}
	
	
}
