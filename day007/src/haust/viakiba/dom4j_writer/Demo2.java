package haust.viakiba.dom4j_writer;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/*
 * 写出文档的细节
 * */

public class Demo2 {
	public static void main(String[] args) throws Exception{
		//文档读取
		Document doc=new SAXReader().read(new File("./src/contact.xml"));
		
		/*
		 * 指定输出的位置
		 * */
		FileOutputStream out=new FileOutputStream("e:/contact.xml");
		
		/*
		 * 指定输出格式
		 * */
		
		//OutputFormat format=OutputFormat.createCompactFormat();
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		//创建写出对象
		XMLWriter writer=new XMLWriter(out,format);
		//写出对象
		writer.write(doc);
		//关闭输出流
		writer.close();
	}
}
