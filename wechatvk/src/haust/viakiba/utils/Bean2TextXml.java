package haust.viakiba.utils;

import com.thoughtworks.xstream.XStream;

import haust.viakiba.entity.MessageTextBean;

public class Bean2TextXml {
	public static String beantoTextXml(MessageTextBean mtb){
		XStream xst = new XStream();
		
		String fromUserName = mtb.getFromUserName();
		String toUserName = mtb.getToUserName();
		
		
		
		xst.alias("xml", mtb.getClass());//标签对与属性名一致
		
		String mtbBean2Str=xst.toXML(mtb);
		
		return mtbBean2Str;
	}
}
