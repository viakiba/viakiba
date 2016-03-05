package gz.itcast.a_dom4j_read;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/**
 * 第二个dom4j读取xml文件内容
 * 节点
 * 标签
 * 属性
 * 文本
 * @author APPle
 *
 */
public class Demo2 {
	
	/**
	 * 得到节点信息
	 */
//	@Test
//	public void test1() throws Exception{
//		//1.读取xml文档，返回Document对象
//		SAXReader reader = new SAXReader();
//		Document doc = reader.read(new File("./src/contact.xml"));
//		
//		//2.nodeIterator: 得到当前节点下的所有子节点对象(不包含孙以下的节点)
//		Iterator<Node> it = doc.nodeIterator();
//		while(it.hasNext()){//判断是否有下一个元素
//			Node node = it.next();//取出元素
//			String name = node.getName();//得到节点名称
//			//System.out.println(name);
//			
//			//System.out.println(node.getClass());
//			//继续取出其下面的子节点
//			//只有标签节点才有子节点
//			//判断当前节点是否是标签节点
//			if(node instanceof Element){
//				Element elem = (Element)node;
//				Iterator<Node> it2 = elem.nodeIterator();
//				while(it2.hasNext()){
//					Node n2 = it2.next();
//					System.out.println(n2.getName());
//				}
//			}
//		}
//	}
//	
//	/**
//	 * 遍历xml文档的所有节点
//	 * @throws Exception
//	 */
//	@Test
//	public void test2() throws Exception{
//		//1.读取xml文档，返回Document对象
//		SAXReader reader = new SAXReader();
//		Document doc = reader.read(new File("./src/contact.xml"));
//		
//		//得到根标签
//		Element rooElem = doc.getRootElement();
//		
//		getChildNodes(rooElem);
//
//	}
//	
//	/**
//	 * 获取 传入的标签下的所有子节点
//	 * @param elem
//	 */
//	private void getChildNodes(Element elem){
//		System.out.println(elem.getName());
//		
//		//得到子节点
//		Iterator<Node> it = elem.nodeIterator();
//		while(it.hasNext()){
//			Node node = it.next();
//			
//			//1.判断是否是标签节点
//			if(node instanceof Element){
//				Element el = (Element)node;
//				//递归
//				getChildNodes(el);
//			}
//		};
//	}
//	
	
	
//	/**
//	 * 获取标签
//	 */
	
	
//	@Test
//	public void test3() throws Exception{
//		//1.读取xml文档，返回Document对象
//		SAXReader reader = new SAXReader();
//		Document doc = reader.read(new File("./src/contact.xml"));
//		
//		//2.得到根标签
//		Element  rootElem = doc.getRootElement();
//		//得到标签名称
//		String name = rootElem.getName();
//		System.out.println(name);
//		
//		//3.得到当前标签下指定名称的第一个子标签
//		/*
//		Element contactElem = rootElem.element("contact");
//		System.out.println(contactElem.getName());
//		*/
//		
//		//4.得到当前标签下指定名称的所有子标签
//		/*
//		Iterator<Element> it = rootElem.elementIterator("contact");
//		while(it.hasNext()){
//			Element elem = it.next();
//			System.out.println(elem.getName());
//		}
//		*/
//		
//		//5.得到当前标签下的的所有子标签
//		List<Element> list = rootElem.elements();
//		//遍历List的方法
//		//1)传统for循环  2）增强for循环 3）迭代器
//		/*for(int i=0;i<list.size();i++){
//			Element e = list.get(i);
//			System.out.println(e.getName());
//		}*/
//		
//	/*	for(Element e:list){
//			System.out.println(e.getName());
//		}*/
//		/*
//		Iterator<Element> it = list.iterator(); //ctrl+2 松开 l
//		while(it.hasNext()){
//			Element elem = it.next();
//			System.out.println(elem.getName());
//		}*/
//		
//		//获取更深层次的标签(方法只能一层层地获取)
//		Element nameElem = doc.getRootElement().
//					element("contact").element("name");
//		System.out.println(nameElem.getName());
//		
//	}
	
	/**
	 * 获取属性
	 */
	@Test
	public void test4() throws Exception{
		//1.读取xml文档，返回Document对象
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./src/contact.xml"));
		
		//获取属性：（先获的属性所在的标签对象，然后才能获取属性）
		//1.得到标签对象
		Element contactElem = doc.getRootElement().element("contact");
		//2.得到属性
		//2.1  得到指定名称的属性值
		/*
		String idValue = contactElem.attributeValue("id");
		System.out.println(idValue);
		*/
		
		//2.2 得到指定属性名称的属性对象
		/*Attribute idAttr = contactElem.attribute("id");
		//getName： 属性名称    getValue：属性值
		System.out.println(idAttr.getName() +"=" + idAttr.getValue());*/
		
		//2.3 得到所有属性对象,返回LIst集合
		/*List<Attribute> list = contactElem.attributes();
		//遍历属性
		for (Attribute attr : list) {
			System.out.println(attr.getName()+"="+attr.getValue());
		}*/
		
		//2.4 得到所有属性对象，返回迭代器
		Iterator<Attribute> it = contactElem.attributeIterator();
		while(it.hasNext()){
			Attribute attr = it.next();
			System.out.println(attr.getName()+"="+attr.getValue());
		}
		
	}
//	
//	/**
//	 * 获取文本
//	 */
//	@Test
//	public void test5() throws Exception{
//		//1.读取xml文档，返回Document对象
//		SAXReader reader = new SAXReader();
//					
//		Document doc = reader.read(new File("./src/contact.xml"));
//		
//		
//		/**
//		 * 注意: 空格和换行也是xml的内容
//		 */
//		String content = doc.getRootElement().getText();
//		System.out.println(content);
//		
//		
//		//获取文本（先获取标签，再获取标签上的文本）
//		Element nameELem = 
//			doc.getRootElement().element("contact").element("name");
//		//1. 得到文本
//		String text = nameELem.getText();
//		System.out.println(text);
//		
//		//2. 得到指定子标签名的文本内容
//		String text2 = 
//			doc.getRootElement().element("contact").elementText("phone");
//		System.out.println(text2);
//		
//	}
//	
//	
}
