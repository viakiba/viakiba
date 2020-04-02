package haust.viakiba.sucai.url2bean;


import haust.viakiba.sucai.entity.One;
import haust.viakiba.sucai.xmlutil.Xml2Doc;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

public class One2bean {
	public static List<One> getZhiFromUrl(URL url) throws Exception{
		List<One> list = new ArrayList<One>();
		Document doc = Xml2Doc.getDoc(url);
		@SuppressWarnings("unchecked")
		List<Element> items =(List<Element>) doc.selectNodes("/rss/channel/item");
		for(Element e:items){
			One sspai = new One();
			
			sspai.setTitle(e.elementText("title"));
			sspai.setAuthor(e.elementText("author"));
			sspai.setLink(e.elementText("link"));
			sspai.setDescription(e.elementText("description"));
			sspai.setPubDate("pubDate");
			
			list.add(sspai);
		}
		return list;
	}
}
