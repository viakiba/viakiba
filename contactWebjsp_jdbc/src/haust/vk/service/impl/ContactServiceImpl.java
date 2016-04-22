package haust.vk.service.impl;

import java.util.List;

import haust.vk.dao.ContactDao;
import haust.vk.dao.impl.ContactDaoMySQLImpl;
import haust.vk.dao.impl.ImplContactDao;
import haust.vk.entity.Contact;
import haust.vk.exception.NameRepeatException;
import haust.vk.service.ContactService;

/**
 * @author vk
 *
 * 2016年4月21日
 */
public class ContactServiceImpl implements ContactService{
	ContactDao dao=new ContactDaoMySQLImpl();
	@Override
	public void addContact(Contact contact)  throws NameRepeatException{
		// TODO Auto-generated method stub
		if(dao.checkContact(contact.getName())){
			throw new NameRepeatException("姓名重复，不可使用，请使用修改");
		}
		dao.addContact(contact);
	}

	@Override
	public void updateContact(Contact contact) {
		// TODO Auto-generated method stub
		dao.updateContact(contact);
	}

	@Override
	public void deleteContact(String id) {
		// TODO Auto-generated method stub
		dao.deleteContact(id);
	}

	@Override
	public List<Contact> findAll() {
		return dao.findAll();
	}

	@Override
	public Contact findById(String id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

}
