package haust.vk.e_aop_anno;

import org.springframework.stereotype.Component;

/*
 * 对象保护
 */
@Component
public class UserDao implements IUserDao{
	@Override
	public void save() {
		System.out.println("=============核心业务：保存=======");
	}
}
