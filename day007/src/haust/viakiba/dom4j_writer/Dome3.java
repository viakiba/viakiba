package haust.viakiba.dom4j_writer;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;
/*
 * 修改xml内容
 * 增加：文档，标签 ，属性
 * 修改：属性值，文本
 * 删除：标签，属性
 * @author viakiba
 * */


public class Dome3 {
	@Test
	public void test() throws Exception{
		/*
		 * 创建文档
		 * */
		Document doc=DocumentHelper.createDocument();
		//增加标签
		Element rootEle=doc.addElement("contactlist");
		//增加标签
		Element contact=rootEle.addElement("contact");
		//设置标签属性
		contact.addAttribute("id", "001");
		//设置标签文本内容
		contact.setText("idshiduosaha");

		
		
		
		
		FileOutputStream out=new FileOutputStream("E:/contact.xml");
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		
		XMLWriter writer=new XMLWriter(out,format);
		
		writer.write(doc);
		
		writer.close();
	}
	
	/**
	 * 修改：属性值，文本
	 * @throws Exception
	 */
	@Test
	public void test2()	throws Exception{
		Document doc=new SAXReader().read((new File("./src/contact.xml")));
//		Element Ele=doc.getRootElement().element("contact");
//		Attribute attr=Ele.attribute("id");
//		attr.setValue("012");
		
		/**
		 * 方案二： 修改属性值
		 */
//		Element ele=doc.getRootElement().element("contact");
//		
//		ele.addAttribute("id", "008");
		
		/**
		 * 修改文本 1.得到标签对象 2.修改文本
		 */
		
		Element ele=doc.getRootElement().element("contact").element("name");
		ele.setText("hahaahah");
		
		
		FileOutputStream out=new FileOutputStream("E:/contact.xml");
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		
		XMLWriter writer=new XMLWriter(out,format);
		
		writer.write(doc);
		
		writer.close();
		
	}
	
	/**
	 * 删除：标签，属性
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception{
		Document doc = new SAXReader().read("./src/contact.xml");
		
		Element ele=doc.getRootElement().element("contact");
		
		//ele.element("name").detach();
		
		Attribute attr= ele.attribute("id");
		attr.detach();
		
		FileOutputStream out=new FileOutputStream("E:/contact.xml");
		
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		
		XMLWriter writer=new XMLWriter(out,format);
		
		writer.write(doc);
		writer.close();
		
	}
}
