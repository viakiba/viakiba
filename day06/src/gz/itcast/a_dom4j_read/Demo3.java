package gz.itcast.a_dom4j_read;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Text;
import org.dom4j.io.SAXReader;
import org.junit.Test;
/**
 * 练习-完整读取xml文档内容
 * @author APPle
 *
 */
public class Demo3 {

	@Test
	public void test() throws Exception{
		//读取xml文档
		SAXReader reader = new SAXReader();
		Document doc = 
				reader.read(new File("./src/contact.xml"));
		
		//读取根标签
		Element rootELem = doc.getRootElement();
		
		StringBuffer sb = new StringBuffer();
		
		getChildNodes(rootELem,sb);
		
		System.out.println(sb.toString());
		
	}
	
	/**
	 * 获取当前标签的所有子标签
	 */
	private void getChildNodes(Element elem,StringBuffer sb){
		//System.out.println(elem.getName());
		
		//开始标签
		sb.append("<"+elem.getName());
		
		//得到标签的属性列表
		List<Attribute> attrs = elem.attributes();
		if(attrs!=null){
			for (Attribute attr : attrs) {
				//System.out.println(attr.getName()+"="+attr.getValue());
				sb.append(" "+attr.getName()+"=\""+attr.getValue()+"\"");
			}
		}
		sb.append(">");
		
		//得到文本
		//String content = elem.getText();
		//System.out.println(content);
		Iterator<Node> it = elem.nodeIterator();
		while(it.hasNext()){
			Node node = it.next();
			
			//标签
			if(node instanceof Element){
				Element el = (Element)node;
				getChildNodes(el,sb);
			}
			
			//文本
			if(node instanceof Text){
				Text text = (Text)node;
				sb.append(text.getText());
			}
		}
		
		//结束标签
		sb.append("</"+elem.getName()+">");
		
		
		
		
	}
}
