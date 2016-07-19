package haust.vk.e_anno2;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

//@Component("userService")  // userService加入ioc容器

//@Component

@Service   // 表示业务逻辑层的组件
public class UserService {
	
	//	@Resource					//  根据类型查找 【在容器中要确保该类型只有一个变量】
	
	@Resource(name = "userDao")  // 根据名称查找
	public UserDao userDao ;
	// IOC：对象的创建交给spring的外部容器完成
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void save(){
		userDao.save();
	}
}
