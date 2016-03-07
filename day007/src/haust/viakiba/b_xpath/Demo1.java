package haust.viakiba.b_xpath;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


/*
    绝对路径      表示从xml的根位置开始或子元素（一个层次结构）
				//     相对路径       表示不分任何层次结构的选择元素。
				*      通配符         表示匹配所有元素
				[]      条件           表示选择什么条件下的元素
				@     属性            表示选择属性节点
				and     关系          表示条件的与关系（等价于&&）
				text()    文本           表示选择文本内容
 */
public class Demo1 {
	public static void main(String[] args) throws Exception{
		Document doc=new SAXReader().read(new File("./src/contact.xml"));
		
		Element ele=doc.getRootElement();
		Element elem=(Element)doc.selectSingleNode("//*[@id='001']");
		
		elem.detach();
		
		FileOutputStream out=new FileOutputStream("E:/student.xml") ;
		
		OutputFormat format=new OutputFormat();
		format.setEncoding("utf-8");
		format.createPrettyPrint();
		
		XMLWriter writer=new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
			
	}
	
	
}
