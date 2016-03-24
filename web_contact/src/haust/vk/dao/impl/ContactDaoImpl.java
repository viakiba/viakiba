package haust.vk.dao.impl;


import haust.vk.entity.Contact;

import java.util.List;

public interface ContactDaoImpl {
	/*
	 * 增删改查 接口设计
	 */
	public void addContact(Contact contact);//添加联系人
	public void updateContact(Contact contact);//修改联系人
	public void deleteContact(String id);//删除联系人
	public List<Contact> findAll();  //查询所有联系人
	public Contact findById(String id);//根据编号查询联系人
	
	
	
}
