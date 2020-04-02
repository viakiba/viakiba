package haust.viakiba.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlJson2Map {
	public static Map<String , String > toMap(HttpServletRequest req) throws Exception{
		Map<String , String > map = new HashMap<String, String>();
		map = Xml2Map(req);
		return map;
	}
	
	//Json转Map
	public Map<String , String > Json2Map(HttpServletRequest req) throws Exception{
		Map<String , String > map = new HashMap<String, String>();
		
		
		
		
		
		return map;
	}
	
	//Xml转Map
	public static Map<String , String > Xml2Map(HttpServletRequest req) throws Exception{
		SAXReader reader = new SAXReader();
		Map<String , String > map = new HashMap<String, String>();
		
		InputStream ins = req.getInputStream();
		Document doc = reader.read(ins);
		
		Element rootElement = doc.getRootElement();
		List<Element> list = rootElement.elements();
		ins.close();
		
		for(Element e:list){
			map.put(e.getName(), e.getText());
		}
		/*System.out.println("==========map========");
		
		System.out.println(map.get("FromUserName"));
		System.out.println(map.get("ToUserName"));
		System.out.println(map.get("Content"));
		System.out.println(map.get("MsgType"));
		System.out.println(map.get("MsgId"));
		
		System.out.println("===========map=========");*/
		return map;
	}
	
}
