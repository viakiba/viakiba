package haust.viakiba.sucai.url2bean;


import haust.viakiba.sucai.entity.Sspai;
import haust.viakiba.sucai.xmlutil.Xml2Doc;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

public class Sspai2bean {
	public static List<Sspai> getZhiFromUrl(URL url) throws Exception{
		List<Sspai> list = new ArrayList<Sspai>();
		Document doc = Xml2Doc.getDoc(url);
		@SuppressWarnings("unchecked")
		List<Element> items =(List<Element>) doc.selectNodes("/rss/channel/item");
		int i = 0;
		for(Element e:items){
			Sspai sspai = new Sspai();
			
			sspai.setTitle(e.elementText("title"));
			sspai.setCreator(e.elementText("dc:creator"));
			sspai.setLink(e.elementText("link"));
			sspai.setDescription(e.elementText("description"));
			sspai.setPubDate("pubDate");
			
			i++;
			if(i==6){
				break;
			}
			list.add(sspai);
		}
		return list;
	}
}
