package haust.vk.g_point;


/*
 * 对象保护
 */
public class UserDao implements IUserDao{
	@Override
	public void save() {
		System.out.println("=============核心业务：保存=======");
	}
}
