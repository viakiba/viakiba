package test;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyDefaultHandler4 extends DefaultHandler {
	@Override
	public void startDocument() throws SAXException {
		System.out.println("MyDefaultHandler4.startDocument->");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("MyDefaultHandler4.startElement->"+qName);
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String str=new String(ch,start,length);
		System.out.println("MyDefaultHandler4.characters->"+str);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("MyDefaultHandler4.endElement->"+qName);
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println("MyDefaultHandler4.endDocument->");
	}
}
