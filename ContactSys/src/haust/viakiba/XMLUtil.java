package haust.viakiba;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLUtil {
	public static Document getDocument(){
		try {
			File file=new File("E:/contact.xml");
			SAXReader reader=new SAXReader();
			Document doc=reader.read(file);
			return doc;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	public static void write2XML(Document doc) throws Exception{
		//–¥»Î
		FileOutputStream out=new FileOutputStream("E:/contact.xml");
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer=new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
		}
}
