package haust.vk.d_myaop1;

import org.springframework.stereotype.Component;
@Component
public class UserDao implements IUserDao{
	@Override
	public void save() {
		System.out.println("打印核心业务");
	}
}
