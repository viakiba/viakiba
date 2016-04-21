package haust.vk.dao.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import haust.vk.XMLUtil.XMLUtil;
import haust.vk.dao.ContactDao;
import haust.vk.entity.Contact;
/*
<contact id="1">
		<name>eric</name>
		<gender>男</gender>
		<age>20</age>
		<phone>1343333</phone>
		<email>eric@qq.com</email>
		<qq>554444</qq>
	</contact>
*/
/**
 * @author vk
 *
 * 2016年4月21日
 */
public class ImplContactDao implements ContactDao{
	
	@Override
	public void addContact(Contact contact) {
		try {
			File file=new File("e:/contact1.xml");
			Element rootElem=null;//根节点
			Document doc=null;//文档
			//首先要获得文档 
			//文件不存在 创建
			if(!file.exists()){
				doc=DocumentHelper.createDocument();
				//添加根节点
				rootElem=doc.addElement("contactList");
			}else{//文件存在     则获取
				doc=XMLUtil.getDocument();
				//获取根节点
				rootElem=doc.getRootElement();
			}
			
			//创建一个uuid值 用于唯一标记联系人
			String uuid = UUID.randomUUID().toString().replace("-", "");
			//根节点下添加联系人节点 名字是 contact
			Element eleContact=rootElem.addElement("contact");
			//添加contact 的属性
			eleContact.addAttribute("id", uuid);
			eleContact.addElement("name").setText(contact.getName());
			eleContact.addElement("gender").setText(contact.getGender());
			eleContact.addElement("age").setText(contact.getAge()+"");
			eleContact.addElement("phone").setText(contact.getPhone());
			eleContact.addElement("email").setText(contact.getEmail());
			eleContact.addElement("qq").setText(contact.getQq());
			XMLUtil.writer2Xml(doc);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateContact(Contact contact) {
		try {
			//分析：更改的情况下，说明文件存在。所以获取文件 然后得到contact属性 重现设置即可
			Document doc=XMLUtil.getDocument();
			Element rootElem=doc.getRootElement();
			//xpath id 找到对应的联系人
			Element contactElement=(Element) doc.selectSingleNode("//contact[@id='"+contact.getId()+"']");

			contactElement.element("name").setText(contact.getName());
			contactElement.element("gender").setText(contact.getGender());
			contactElement.element("age").setText(contact.getAge()+"");
			contactElement.element("phone").setText(contact.getPhone());
			contactElement.element("email").setText(contact.getEmail());
			contactElement.element("qq").setText(contact.getQq());
			
			XMLUtil.writer2Xml(doc);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
/*
 测试 uuid
 public static void main(String args[]){
	String str = UUID.randomUUID().toString().replace("-", "");
	System.out.println(str+"---"+str.length());
}
*/
	@Override
	public void deleteContact(String id) {
		try {
			Document doc=XMLUtil.getDocument();
			Element elemContact=(Element) doc.selectSingleNode("//contact[@id='"+id+"']");
			
			Contact c=null;
			if(elemContact!=null){
				elemContact.detach();
			}
			
			XMLUtil.writer2Xml(doc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<Contact> findAll() {
		try {
			List<Contact> list=new ArrayList<Contact>();
			Document doc=XMLUtil.getDocument();
			List<Element> conList =(List<Element>) doc.selectNodes("//contact");
			 
			for(Element e:conList){
				Contact c=new Contact();
				c.setId(e.attributeValue("id"));
				//获取子节点的文本 对应节点的名称
				c.setName(e.elementText("name"));
				c.setGender(e.elementText("gender"));
				c.setAge(Integer.parseInt(e.elementText("age")));
				c.setPhone(e.elementText("phone"));
				c.setEmail(e.elementText("email"));
				c.setQq(e.elementText("qq"));
				list.add(c);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Contact findById(String id) {
		try {
			Document doc=XMLUtil.getDocument();
			Element e=(Element) doc.selectSingleNode("//contact[@id='"+id+"']");
			Contact c=null;
			if(e!=null){
				c=new Contact();
				//获取节点的属性
				c.setId(e.attributeValue("id"));
				//获取子节点的文本 对应节点的名称
				c.setName(e.elementText("name"));
				c.setGender(e.elementText("gender"));
				c.setAge(Integer.parseInt(e.elementText("age")));
				c.setPhone(e.elementText("phone"));
				c.setEmail(e.elementText("email"));
				c.setQq(e.elementText("qq"));
			}
			return c;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean checkContact(String name) {
		try {
			Document doc=XMLUtil.getDocument();
			Element elem=(Element) doc.selectSingleNode("//contact[text()='"+name+"']");
			if(elem==null){
				return false;
			}else{
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
}
