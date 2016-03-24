package haust.vk.dao.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import haust.vk.dao.impl.ContactDaoImpl;
import haust.vk.entity.Contact;
import haust.vk.util.XMLUtil;

public class ContactDao implements ContactDaoImpl{
	/**
	 * 添加联系人
	 */
	public void addContact(Contact contact){
		try {
			File file= new File("e:/contact.xml");
			Document doc=null;
			Element rootElem=null;
			if(!file.exists()){
				doc=DocumentHelper.createDocument();
				rootElem=doc.addElement("contactList");
			}else{
				doc=XMLUtil.getDocument();
				rootElem=doc.getRootElement();
			}
			
			/**
			 * <contact id="1">
					<name>eric</name>
					<gender>男</gender>
					<age>20</age>
					<phone>1343333</phone>
					<email>eric@qq.com</email>
					<qq>554444</qq>
				</contact>
			 */
			
			Element contactElem=rootElem.addElement("contact");
			String uuid = UUID.randomUUID().toString().replace("-", "");
			contactElem.addAttribute("id", uuid);
			contactElem.addElement("name").setText(contact.getName());
			contactElem.addElement("gender").setText(contact.getGender());
			contactElem.addElement("age").setText(contact.getAge()+"");
			contactElem.addElement("phone").setText(contact.getPhone());
			contactElem.addElement("email").setText(contact.getEmail());
			contactElem.addElement("qq").setText(contact.getQq());
			
			XMLUtil.write2xml(doc);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}
	
	public void deleteContact(String id){
		try {
			Document doc=XMLUtil.getDocument();
			Element contactElement=(Element)doc.selectSingleNode("\\contact[@id='"+id+"']");
			
			if(contactElement!=null){
				contactElement.detach();
			}
			XMLUtil.write2xml(doc);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public Contact findById(String id){
		try {
			Document doc=XMLUtil.getDocument();
			Element e=(Element)doc.selectSingleNode("\\contact[@id='"+id+"']");
			Contact c=null;
			if(e!=null){
			c=new Contact();
			c.setId(e.attributeValue("id"));
			c.setAge(Integer.parseInt(e.attributeValue("age")));
			c.setEmail(e.attributeValue("email"));
			c.setGender(e.attributeValue("gender"));
			c.setName(e.attributeValue("name"));
			c.setPhone(e.attributeValue("phone"));
			c.setQq(e.attributeValue("qq"));
			
			return c;
			}else{
				return null;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void updateContact(Contact contact){
		try {
			Document doc=XMLUtil.getDocument();
			int id=Integer.parseInt(contact.getId());
			Element contactElem=(Element)doc.selectSingleNode("//contact[@id='"+id+"']");
			
			contactElem.addElement("name").setText(contact.getName());
			contactElem.addElement("gender").setText(contact.getGender());
			contactElem.addElement("age").setText(contact.getAge()+"");
			contactElem.addElement("phone").setText(contact.getPhone());
			contactElem.addElement("email").setText(contact.getEmail());
			contactElem.addElement("qq").setText(contact.getQq());
			
			XMLUtil.write2xml(doc);
		
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	
	}
	
	public List<Contact> findAll() {
		Document doc=null;
		try {
			doc = XMLUtil.getDocument();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		List<Contact> list=new ArrayList<Contact>();
		
		List<Element> conList=(List<Element>)doc.selectNodes("//contact");
		
		
		for(Element e:conList){
			Contact c=new Contact();
			c.setId(e.attributeValue("id"));
			c.setName(e.elementText("name"));
			c.setGender(e.elementText("gender"));
			c.setAge(Integer.parseInt(e.elementText("age")));
			c.setPhone(e.elementText("phone"));
			c.setEmail(e.elementText("email"));
			c.setQq(e.elementText("qq"));
			list.add(c);
		}
		return list;
	}
	
	
}
