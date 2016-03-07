package haust.viakiba.b_xpath;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Demo3 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("请输入用户名");
		String name=br.readLine();
		
		System.out.println("请输入密码");
		String password=br.readLine();
		
		Document doc=new SAXReader().read(new File("./src/user.xml"));
		
		Element ele=(Element)doc.getRootElement().selectSingleNode("//user[@name='"+name+"'and @password='"+password+"']");
		if(ele !=null){
				System.out.println("登陆成功");													//user[@name='" +name +"' and @password='"+password+"']
		}else{
			System.out.println("密码或用户名错误");
		}
	}
}
