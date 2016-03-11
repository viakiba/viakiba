package haust.viakiba;

import org.junit.Before;
import org.junit.Test;

public class TestOpeater {
ContactOperator operator=null;
	
	@Before
	public void init(){
		operator=new ContactOpertorImpl();
		
	}
	@Test
	public void testAdd(){
		Contact contact=new Contact();
		contact.setId("12");
		contact.setName("saasasadavxcva");
		contact.setGender("ÄÐ");
		contact.setAge(45+"");
		contact.setPhone("asdad5454");
		contact.setEmail("488441@qq.com");
		contact.setQq("4645646");
		
		operator.addContact(contact);
	}
}
