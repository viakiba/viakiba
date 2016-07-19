package haust.vk.c_property;

public class UserService {
	private UserDao userDao = new UserDao();
	
	// IOC：对象的创建交给spring的外部容器完成
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void save() {
		userDao.save();
	}
}
