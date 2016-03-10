package test;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class demo1 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, Exception {
		SAXParser parser=SAXParserFactory.newInstance().newSAXParser();
		parser.parse(new File("./src/contact.xml"),new MyDefaultHandler4());		
	}
}
