package haust.viakiba;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class MyDefaultHandler3 extends DefaultHandler {
	List<Contact> list=new ArrayList<Contact>();
	public List<Contact> getList(){
		return list;
	}
	/*
	 * 思路：
	 * 创建Contact对象
	 * 把每隔contact标签存到contact对象中
	 * 把contact对象放到list中
	 */
	private String curTag;
	private Contact contact;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		curTag=qName;
		if("contact".equals(qName)){
			contact=new Contact();
			contact.setId(attributes.getValue("id"));
		}
	
	}
	
	 @Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String str=new String(ch,start,length);
		
		if("name".equals(curTag)){
			contact.setName(str);
		}
		if("gender".equals(curTag)){
			contact.setGender(str);		
				}
		if("age".equals(curTag)){
			contact.setGender(str);
		}
		if("phone".equals(curTag)){
			contact.setPhone(str);
		}
		if("email".equals(curTag)){
			contact.setEmail(str);
		}
		if("qq".equals(curTag)){
			contact.setQq(str);
		}
	}
	 
	 @Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		curTag=null;
		if("contact".equals(qName)){
			list.add(contact);
		}
	}
}

