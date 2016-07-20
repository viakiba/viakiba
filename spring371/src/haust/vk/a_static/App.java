package haust.vk.a_static;

public class App {
	public static void main(String[] args) {
		//目标对象
		IUserDao target = new UserDao();
		
		//代理
		IUserDao proxy1=new UserDaoProxy(target);
		proxy1.save();
	}
}
