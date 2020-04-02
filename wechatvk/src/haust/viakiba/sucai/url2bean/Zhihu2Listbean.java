package haust.viakiba.sucai.url2bean;

import haust.viakiba.sucai.entity.Zhihu;
import haust.viakiba.sucai.xmlutil.Xml2Doc;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;


public class Zhihu2Listbean {
	public static List<Zhihu> getZhiFromUrl(URL url) throws Exception{
		List<Zhihu> list =new ArrayList<Zhihu>();
		Document zhihudoc = Xml2Doc.getDoc(url);
		
		//��ȡ��ڵ�
		Element root = zhihudoc.getRootElement();
		//��ȡitem�ڵ�
		@SuppressWarnings("unchecked")
		List<Element> items =(List<Element>) zhihudoc.selectNodes("/rss/channel/item");
		int i = 0;
		for(Element e:items){
			Zhihu z = new Zhihu();
			//д������
			//System.out.println(e.element("title").getText());
			z.setTitle(e.element("title").getText());
			//System.out.println(e.element("link").getText());
			z.setLink(e.element("link").getText());
			//System.out.println(e.element("description").getText());
			z.setDescription(e.element("description").getText());
			//System.out.println(e.elementText("pubDate"));
			z.setPubDate(e.elementText("pubDate"));
			//System.out.println(e.elementText("guid"));
			z.setGuid(e.elementText("guid"));
			//System.out.println("=================================");
			//System.out.println(z.toString());
			i++;//����list����Ϊ5
			if(i==6){
				break;
			}
			list.add(z);
		}
		
		return list;
	}
}
