package haust.vk.b_create_obj;

public class ObjectFactory {
	public User getInstance(){
		return new User(100,"工厂掉哦那个实例方法");
	}
	
	public static User getStaticInstance(){
		return new User(101,"工厂：调用静态方法");
	}
}
