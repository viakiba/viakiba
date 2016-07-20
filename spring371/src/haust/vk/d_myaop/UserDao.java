package haust.vk.d_myaop;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
@Component
public class UserDao implements IUserDao{
	@Resource
	private Aop aop;
	@Override
	public void save() {
		aop.begin();
		System.out.println("打印核心业务");
		aop.commit();
	}
}
