package haust.viakiba.b_xpath;

import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;

import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dmeo2 {
	public static void main(String[] args) throws Exception{
		//读取文档
		Document doc=new SAXReader().read("./src/contact.xml");
		//xpath 操作练习
		String xpath="";
		/**
		 * 1.  	/      绝对路径      表示从xml的根位置开始或子元素（一个层次结构）
		 */
		xpath="/contactlist/contact";
		xpath="//name";
		/**
		 * 2. //     相对路径       表示不分任何层次结构的选择元素。
		 */
		xpath="//age";
		/**
		 * 3. *      通配符         表示匹配所有元素
		 */
		xpath="//contact/name";
		xpath="//contact/*";
		/**
		 * 4. []      条件           表示选择什么条件下的元素
		 */
		xpath="/contactList/contact[last()]";
		/**
		 * 5. @     属性            表示选择属性节点
		 */
		xpath="//@id";
		/**
		 *6.  text()   表示选择文本内容
		 */
		xpath="//contact/name[text()='eric']";
		List<Node> list=doc.selectNodes(xpath);
		for(Node li : list){
			System.out.println(li);
		}
		//设置输出位置
		FileOutputStream out=new FileOutputStream("e:/contact.xml");		
		//设置输出的编码如样式
		OutputFormat format=new OutputFormat();
		format.setEncoding("utf-8");
		format.createPrettyPrint();
		//创建写出对象进行写出
		XMLWriter writer=new XMLWriter(out,format);
		writer.write(doc);
		//关闭
		writer.close();
	}
}
