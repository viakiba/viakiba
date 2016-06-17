package haust.vk.ongl;

/**
 * @author vk
 *
 * 2016年6月16日
 */
public class User {
	private Address address=new Address("河南","洛阳");
	private int id;
	private String name;
	
	public User(){
		super();
		
	}
	
	public User(int id , String name){
		this.address=address;
		this.id=id;
		this.name=name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
