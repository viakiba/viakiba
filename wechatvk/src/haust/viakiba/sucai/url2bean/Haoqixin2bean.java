package haust.viakiba.sucai.url2bean;

import haust.viakiba.sucai.entity.Haoqixin;
import haust.viakiba.sucai.xmlutil.Xml2Doc;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

public class Haoqixin2bean {
	public static List<Haoqixin> getZhiFromUrl(URL url) throws Exception{
		List<Haoqixin> list = new ArrayList<Haoqixin>();
		Document doc = Xml2Doc.getDoc(url);
		@SuppressWarnings("unchecked")
		List<Element> items =(List<Element>) doc.selectNodes("/rss/channel/item");
		int i = 0;
		for(Element e:items){
			Haoqixin hqx = new Haoqixin();
			
			hqx.setTitle(e.elementText("title"));
			hqx.setLink(e.elementText("link"));
			hqx.setDescription(e.elementText("description"));
			hqx.setPubDate("pubDate");
			i++;
			if(i==6){
				break;
			}
			list.add(hqx);
		}
		return list;
	}
}
