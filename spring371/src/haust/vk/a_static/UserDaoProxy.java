package haust.vk.a_static;

/**
 * 代理对象(静态代理)
 * 	   代理对象，要实现与目标对象一样的接口
 */
public class UserDaoProxy implements IUserDao{
	private IUserDao target;
	
	public UserDaoProxy(IUserDao target) {
		super();
		this.target = target;
	}



	@Override
	public void save() {
		System.out.println("开始事务。。。");
		
		target.save();//执行目标对象方法
		
		System.out.println("关闭事务。。。");
		
	}
	
}
