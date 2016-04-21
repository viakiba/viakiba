package haust.vk.dao;

import java.util.List;

import haust.vk.entity.Contact;

/**
 * @author vk
 *
 * 2016年4月21日
 */
public interface ContactDao {
	//接口类 定义四个方法 curd
	//添加
	public void addContact(Contact contact);
	//修改
	public void updateContact(Contact contact);
	//删除 
	public void deleteContact(String id);
	//查询所有联系人
	public Contact findById(String id);
	//查询全部
	public List<Contact> findAll();
	//根据姓名查询是否重复
	public boolean checkContact(String name);
}
