package haust.viakiba.dom4j_writer;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Demo4 {
	public static void main(String[] args) throws Exception{
		//创建文档
		Document doc=DocumentHelper.createDocument();
		//创建内容
		Element Students=doc.addElement("Students");
		//创建一级节点
		Element Student=Students.addElement("Student");
		//设置一级节点属性
		Student.addAttribute("id", "1");
		//一级节点创建二级节点
		Element name=Student.addElement("name");
		name.addText("张三");
		Element gender=Student.addElement("gender");
		gender.addText("男");
		Element grader=Student.addElement("grade");
		grader.addText("计算机一班");
		Element address=Student.addElement("address");
		address.addText("广州天河");
		
		//创建一级节点
		Element Student1=Students.addElement("Student");
		//设置一级节点属性
		Student1.addAttribute("id", "2");
		Element name1=Student1.addElement("name");
		name1.addText("李四");
		Element gender1=Student1.addElement("gender");
		gender1.addText("女");
		Element grader1=Student1.addElement("grade");
		grader1.addText("计算机2班");
		Element address1=Student1.addElement("address");
		address1.addText("广州越秀");
		
		
		
		//输出文档
		FileOutputStream out=new FileOutputStream("E:/contact1.xml");
		
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		
		XMLWriter writer=new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
	}
	
}
