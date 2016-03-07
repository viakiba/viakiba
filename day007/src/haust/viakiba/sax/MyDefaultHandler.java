package haust.viakiba.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyDefaultHandler extends DefaultHandler{
	@Override
	public void startDocument() throws SAXException {
		System.out.println("MyDefaultHandler.startDocument()");
	}
	
	/**
	 * 开始标签时调用
	 * @param qName: 表示开始标签的标签名
	 * @param attributes: 表示开始标签内包含的属性列表
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("MyDefaultHandler.startElement()-->"+qName);
	}
	
	/**
	 * 结束标签时调用
	 * @param qName: 结束标签的标签名称
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("MyDefaultHandler.endElement()-->"+qName);
	}
	
	/**
	 * 读到文本内容的时调用
	 * @param ch: 表示当前读完的所有文本内容
	 * @param start： 表示当前文本内容的开始位置
	 * @param length: 表示当前文本内容的长度
	 * char[]（                                       张三              20）   100
	 *                              98 2   
	 */ 
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//得到当前文本内容
		String content = new String(ch,start,length);
		System.out.println("MyDefaultHandler.characters()-->"+content);
	}
	
	/**
	 * 结束文档时调用
	 */
	@Override
	public void endDocument() throws SAXException {
		System.out.println("MyDefaultHandler.endDocument()");
	}
	
	
	
	
}
