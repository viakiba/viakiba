package haust.viakiba;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Demo2 {
	public static void main(String[] args) throws Exception{
		SAXParser parser=SAXParserFactory.newInstance().newSAXParser();

		MyDefaultHandler2 handler=new MyDefaultHandler2();
	
		parser.parse(new File("./src/contact.xml"), handler);
		String content=handler.getContent();
		System.out.println(content);
	}
}
