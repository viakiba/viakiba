package haust.vk.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLUtil {
	/*
	 * 读取xml文档的方法
	 */
	public static Document getDocument() throws Exception{
		Document doc=new SAXReader().read(new File("e:/contact.xml"));
		return doc;
	}
	/*
	 * 写到xml文档中
	 */
	public static void write2xml(Document doc){
		try {
			FileOutputStream out=new FileOutputStream("e:/contact.xml");
			OutputFormat format=new OutputFormat();
			format.setEncoding("utf-8");
			format.createPrettyPrint();
			XMLWriter writer=new XMLWriter(out,format);
			writer.write(doc);
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
}
