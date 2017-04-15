package haust.vk.service;

import java.util.List;
import java.util.Map;

public interface UserService {
	/**
	 * read-only:即此方法对数据库只能执行只读操作，否则报错，（报错的例子 参考 selectListUser2）
	 * @Author : viakiba
	 * @return
	 * 2017-04-14
	 */
	public List<Map> selectListUser1();
	
	/**
	 * 此时由于执行是update操作 所以此方法报错
	 * @Author : viakiba
	 * @param map
	 * 2017-04-14
	 */
	public void selectListUser2(Map map);
	/**
	 * 查看回滚   抛出exception
	 * @Author : viakiba
	 * @param uid
	 * 2017-04-14
	 */
	public void deleteUserById(String uid) throws Exception;
	
	/**
	 * propagation:never  在无transaction状态下执行；如果当前已有transaction，则抛出异常IllegalTransactionStateException。
	 * @Author : viakiba
	 * @return
	 * 2017-04-14
	 */
	public void findListUser1() throws Exception;
	
}
