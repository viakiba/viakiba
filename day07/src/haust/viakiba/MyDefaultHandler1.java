package haust.viakiba;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyDefaultHandler1 extends DefaultHandler {
	
	/*
	 * 开始文档是调用
	 */
	
	@Override
	public void startDocument() throws SAXException{
		System.out.println("MyDefaultHandler1.startDocument");
	}
	/*
	 * @param qName:表示开始标签的标签名
	 * @paran attributes:表示开始标签的属性列表
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("MyDefaultHandler1.startElement->"+qName);
	}
	/*
	 * @param qName:表示开始标签的标签名
	 * */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
	System.out.println("MyDefaultHandler1.endElement->"+qName);	
	}
	
	/*
	 * @param ch:表示xml所以文本内容
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String str=new String(ch,start,length);
		System.out.println("MyDefaultHandler1.characters->"+str);
	}
	
	/*
	 * 结束文档是调用
	 */
	@Override
	public void endDocument() throws SAXException{
		System.out.println("MyDefaultHandler1.endDocument");
	}
}
