package haust.viakiba;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class ContactOpertorImpl implements ContactOperator {
	@Override
	public void addContact(Contact contact) {
		try {
			File file=new File("E:/contact.xml");
			Document doc=null;
			Element rootElem=null;
			
			if(!file.exists()){
				doc=DocumentHelper.createDocument();
				rootElem=doc.addElement("contactlist");
			}else{
				doc=XMLUtil.getDocument();
				rootElem=doc.getRootElement();
			}
			
			Element contactElem=rootElem.addElement("contact");
			contactElem.addAttribute("id", contact.getId());
			contactElem.addElement("name").setText(contact.getName());
			contactElem.addElement("gender").setText(contact.getGender());
			contactElem.addElement("age").setText(contact.getAge());
			contactElem.addElement("phone").setText(contact.getPhone());
			contactElem.addElement("email").setText(contact.getEmail());
			contactElem.addElement("qq").setText(contact.getQq());
			
			XMLUtil.write2XML(doc);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		
	}

	@Override
	public void deleteContact(String id) {
		try {
			Document doc=XMLUtil.getDocument();
			Element contactElem=(Element)doc.selectSingleNode("//contact[@id='"+id+"']");
			contactElem.detach();
			
			XMLUtil.write2XML(doc);}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);			
		}
	}

	@Override
	public void updateContact(Contact contact) {
		try {
			Document doc=XMLUtil.getDocument();
			Element contactElem=(Element)doc.selectSingleNode("//contact[@id='"+contact.getId()+"']");
			contactElem.element("name").setText(contact.getName());
			contactElem.element("gender").setText(contact.getGender());
			contactElem.element("age").setText(contact.getAge()+"");
			contactElem.element("phone").setText(contact.getPhone());
			contactElem.element("email").setText(contact.getEmail());
			contactElem.element("qq").setText(contact.getQq());
			
			
			XMLUtil.write2XML(doc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<Contact> findAll() {
		Document doc=XMLUtil.getDocument();
		
		List<Contact> list=new ArrayList<Contact>();
		List<Element> conlist=(List<Element>)doc.selectNodes("//contact");
		for(Element con:conlist){
			Contact c=new Contact();
			c.setId(con.attributeValue("id"));
			c.setName(con.elementText("name"));
			c.setGender(con.elementText("gender"));
			c.setAge(Integer.parseInt( con.elementText("age"))+"");
			c.setPhone(con.elementText("phone"));
			c.setEmail(con.elementText("email"));
			c.setQq(con.elementText("qq"));
			
			list.add(c);
			
		}
		
		return list;
	}

}
