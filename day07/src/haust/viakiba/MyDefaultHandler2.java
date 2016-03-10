package haust.viakiba;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyDefaultHandler2 extends DefaultHandler  {
	private StringBuffer sb=new StringBuffer();
	
	public String getContent(){
		return sb.toString();
	}
	
	
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		sb.append("<"+qName);
		//ÅÐ¶ÏÊôÐÔ
		if(attributes!=null){
			for(int i=0;i<attributes.getLength();i++){
				String attrName=attributes.getQName(i);
				String attrValue=attributes.getValue(i);
				
				sb.append("  "+attrName+"=\""+attrValue+"\"");
				
			}
		}
		
		
		sb.append(">");
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String str=new String(ch,start,length);
		sb.append(str);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		sb.append("</"+qName+">");
	}
	
	
}
