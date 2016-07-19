package haust.vk.e_anno;

import org.springframework.stereotype.Component;

//把当前对象加入ioc容器
//相当于bean.xml 【<bean id=userDao class=".." />】
@Component("userDao")
public class UserDao {
	public void save() {
		System.out.println("dao  保存用户");
	}
}
