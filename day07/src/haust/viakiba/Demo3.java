package haust.viakiba;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Demo3 {
	public static void main(String[] args) throws Exception{
		SAXParser parser=SAXParserFactory.newInstance().newSAXParser();
		MyDefaultHandler3 handler=new MyDefaultHandler3();
		File file=new File("./src/contact.xml");
		
		parser.parse(file, handler);
		
		List<Contact> list=handler.getList();
		for(Contact con:list){
			System.out.println(con.toString());
		}
		
	}
}
