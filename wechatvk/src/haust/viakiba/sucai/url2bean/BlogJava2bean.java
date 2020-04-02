package haust.viakiba.sucai.url2bean;


import haust.viakiba.sucai.entity.BlogJava;
import haust.viakiba.sucai.xmlutil.Xml2Doc;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

public class BlogJava2bean {
	public static List<BlogJava> getZhiFromUrl(URL url) throws Exception{
		List<BlogJava> list = new ArrayList<BlogJava>();
		Document doc = Xml2Doc.getDoc(url);
		@SuppressWarnings("unchecked")
		List<Element> items =(List<Element>) doc.selectNodes("/rss/channel/item");
		int i = 0;
		for(Element e:items){
			BlogJava sspai = new BlogJava();
			
			sspai.setTitle(e.elementText("title"));
			sspai.setAuthor(e.elementText("author"));
			sspai.setLink(e.elementText("link"));
			sspai.setDescription(e.elementText("description"));
			sspai.setPubDate("pubDate");
			i++;//控制读取数量为5
			if(i==6){
				break;
			}
			list.add(sspai);
		}
		return list;
	}
}
