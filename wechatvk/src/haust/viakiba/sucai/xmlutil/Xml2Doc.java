package haust.viakiba.sucai.xmlutil;

import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Xml2Doc {
	public static Document getDoc(URL url) throws Exception{
		SAXReader reader = new SAXReader();
		Document doc = reader.read(url);
		return doc;
	}
}
