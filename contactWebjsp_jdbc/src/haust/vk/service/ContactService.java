package haust.vk.service;

import java.util.List;

import haust.vk.entity.Contact;
import haust.vk.exception.NameRepeatException;

/**
 * @author vk
 *
 * 2016年4月21日
 */
public interface ContactService {
	//添加联系人
	public void addContact(Contact contact) throws NameRepeatException;
	
	//修改联系人
	public void updateContact(Contact contact);
	
	//删除联系人
	public void deleteContact(String id);
	
	//查询所有的联系人
	public List<Contact> findAll();
	
	//根据编号查询联系人
	public Contact findById(String id);
	
}
