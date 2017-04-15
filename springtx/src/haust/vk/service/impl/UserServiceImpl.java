package haust.vk.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import haust.vk.dao.UserDao;
import haust.vk.service.UserService;

/**
 * 此处主要是测试spring对方法名的规范 引入了对事务的管理
 * 名词准备：参考：http://www.cnblogs.com/henryhappier/archive/2010/07/05/1771295.html
 *    DDL：用于定义数据库的三级结构
 *    DML：数据操纵语言  SELECT   INSERT
 *    DCL：数据库控制语言  授权，角色控制等
 *    TCL：事务控制语言
 * 在配置文件spring_dao.xml中，对于事务的作用体现在下面的一串代码：
 * 
 *  <!-- 配置事务切面 即让指定的包下的类需要事务 -->
 *  <tx:advice id="tx" transaction-manager="dataSourceTransactionManager">
    	<tx:attributes>
    		<tx:method name="select*" read-only="true" />
			<tx:method name="*" rollback-for="Throwable"/>
    	</tx:attributes> 
    </tx:advice>
 *   
 *   接下来将对上面的代码进行测试和讲解
 * @author viakiba
 *
 */
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	
	public List<Map> selectListUser1(){
		return userDao.selectUser();
	}
	
	/**
	 * 此时由于执行是update操作 所以此方法报错
	 * @Author : viakiba
	 * @param map
	 * 2017-04-14
	 */
	public void selectListUser2(Map map){
		userDao.updateUserById(map);;
	}
	
	@Override
	public void deleteUserById(String uid) throws Exception {
		userDao.deleteUserById(uid);
		//由于抛出异常  所以执行时会发生回滚 不删除记录  可以进行比对
		throw new Exception();
	}
	
	@Override
	public void findListUser1() throws Exception{
		userDao.deleteUserById("3");
		throw new Exception();
	}
}
