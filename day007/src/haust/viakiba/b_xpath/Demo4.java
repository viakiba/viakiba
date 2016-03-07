package haust.viakiba.b_xpath;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Demo4 {
	public static void main(String[] args) throws Exception{
		Document doc=new SAXReader().read("./src/personList.html");
		
		//∂¡»°±ÌÕ∑
		Element center=(Element)doc.selectSingleNode("//center/h1");
		System.out.println(center.getText());
		
		List<Element> list=(List<Element>) doc.selectNodes("//td");
		for(Element li : list){
			
				System.out.print(li.getText());
			
				System.out.println();
		}
		
	}
}
