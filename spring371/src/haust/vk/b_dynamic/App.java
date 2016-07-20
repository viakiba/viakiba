package haust.vk.b_dynamic;

public class App {
	public static void main(String[] args) {
		//创建目标对象
		IUserDao target = new UserDao();
		
		//输出原始类型  class haust.vk.b_dynamic.UserDao
		System.out.println(target.getClass());
		
		//给目标对象创建  代理代理对象
		IUserDao proxy=(IUserDao) new ProxyFactory(target).getProxyInstance();
		// class $Proxy0   内存中动态生成的代理对象
		System.out.println(proxy.getClass());
		
		//执行方法 代理对象
		proxy.save();
	}
}
