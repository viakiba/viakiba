package haust.vk.e_anno2;

//把当前对象加入ioc容器
//@Component("userDao")   //  相当于bean.xml 【<bean id=userDao class=".." />】

//@Component  // 加入ioc容器的UserDao对象的引用名称， 默认与类名一样， 且第一个字母小写

//@Repository   // 在持久层可以选择用这个注解

public class UserDao {
	
	public UserDao(){
		System.out.println("UserDao.UserDao()");
	}
	
	public UserDao(int id){
		System.out.println("UserDao.UserDao(int id)" + id);
	}
	
	public void save() {
		System.out.println("dao  保存用户");
	}
}
