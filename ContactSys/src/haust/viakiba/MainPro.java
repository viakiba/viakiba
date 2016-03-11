package haust.viakiba;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class MainPro {
	public static void main(String[] args) throws Exception{
		
		ContactOperator operater=new ContactOpertorImpl();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true){
			printMenu();
			String curtag=br.readLine();
			if("1".equals(curtag)){
				Contact contact=new Contact();
				System.out.println("请输入编号：");
				String id=br.readLine();

				System.out.println("请输入姓名：");
				String name=br.readLine();
				
				System.out.println("请输入性别：");
				String gender=br.readLine();
				
				System.out.println("请输入年龄：");
				String age=br.readLine();
				
				System.out.println("请输入电话：");
				String phone=br.readLine();
				
				System.out.println("请输入邮箱：");
				String email=br.readLine();
				
				System.out.println("请输入QQ：");
				String qq=br.readLine();
				
				contact.setId(id);
				contact.setName(name);
				contact.setGender(gender);
				contact.setAge(age+"");
				contact.setPhone(phone);
				contact.setEmail(email);
				contact.setQq(qq);
				
				operater.addContact(contact);
			}
			else if("2".equals(curtag)){
				Contact contact=new Contact();
				//id
				System.out.println("请输入修改id");
				String id=br.readLine();
				//name
				System.out.println("请输入修改name");
				String name=br.readLine();
				//gender
				System.out.println("请输入修改gender");
				String gender=br.readLine();
				//age
				System.out.println("请输入修改age");
				String age=br.readLine();
				//phone
				System.out.println("请输入修改phone");
				String phone=br.readLine();
				//email
				System.out.println("请输入修改email");
				String email=br.readLine();
				//qq
				System.out.println("请输入修改qq");
				String qq=br.readLine();
				
				contact.setId(id);
				contact.setName(name);
				contact.setGender(gender);
				contact.setAge(Integer.parseInt(age)+"");
				contact.setPhone(phone);
				contact.setEmail(email);
				contact.setQq(qq);
				
				operater.updateContact(contact);			
						}
			else if("3".equals(curtag)){
				System.out.println("请输入删除id");
				String id=br.readLine();	
				operater.deleteContact(id);
			}
			else if("4".equals(curtag)){
				List<Contact> list=operater.findAll();
				for(Contact li:list){
					System.out.println(li.toString());
				}
			}else if("Q".equals(curtag)){
				break;
			}else{
				System.out.println("输入命令有误");
			}
			
			}
		}
		
		
	

	private static void printMenu() {
		System.out.println("==================");
		System.out.println("[1]添加联系人");
		System.out.println("[2]修改联系人");
		System.out.println("[3]删除联系人");
		System.out.println("[4]查询所有联系人联系人");
		System.out.println("[Q]添加联系人");
		System.out.println("==================");
	}
}
