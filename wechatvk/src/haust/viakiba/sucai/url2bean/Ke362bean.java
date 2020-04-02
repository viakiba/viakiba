package haust.viakiba.sucai.url2bean;



import haust.viakiba.sucai.entity.Ke36;
import haust.viakiba.sucai.xmlutil.Xml2Doc;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

public class Ke362bean {
	public static List<Ke36> getZhiFromUrl(URL url) throws Exception{
		List<Ke36> list = new ArrayList<Ke36>();
		
		Document doc = Xml2Doc.getDoc(url);
		@SuppressWarnings("unchecked")
		List<Element> items =(List<Element>) doc.selectNodes("/rss/channel/item");
		int i = 0;
		for(Element e:items){
			
			Ke36 z = new Ke36();
			//д������
			//System.out.println(e.element("author").getText());
			z.setAuther(e.element("author").getText());
			z.setLink(e.elementText("link"));
			z.setDescription(e.elementText("description"));
			z.setPubDate(e.elementText("pubDate"));
			i++;//����list����Ϊ5
			if(i==6){
				break;
			}
			list.add(z);
		}
		
		
		return list;
	}
}
