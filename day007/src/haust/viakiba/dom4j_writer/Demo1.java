package haust.viakiba.dom4j_writer;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;



public class Demo1 {
	public static void main(String[] args) throws Exception{
		//读取xml文件或者创建
		Document doc=new SAXReader().read(new File("./src/contact.xml"));
		
		//修改Document对象
		
		//把修改后的对象写进xml文档中
		//1.指定输出的位置
		FileOutputStream out=new FileOutputStream("e:/contact.xml");
		//创建写出对象
		XMLWriter writer=new XMLWriter(out);
		//写出对象
		writer.write(doc);
		//关闭流
		writer.close();
	
	
	}
}
