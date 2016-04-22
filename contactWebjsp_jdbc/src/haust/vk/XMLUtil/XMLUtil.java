package haust.vk.XMLUtil;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @author vk
 *
 * 2016年4月21日
 */
public class XMLUtil {
	public static Document getDocument() throws Exception{
		Document doc=new SAXReader().read(new File("e:/contact1.xml"));
		
		return doc;
	}
	
	public static void writer2Xml(Document doc) throws Exception{
		//指定输出位置
		FileOutputStream out=new FileOutputStream("e:/contact1.xml");
		
		//指定输出格式
		OutputFormat format=new OutputFormat();
		format.createPrettyPrint();
		format.setEncoding("utf-8");
		
		//创建xml的写出流
		XMLWriter write=new XMLWriter(out,format);
		write.write(doc);
		write.close();
	}
}
