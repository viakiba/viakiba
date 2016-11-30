package haust.vk.factory.b_two;

public class SendFactory {
	public SendInterface ProduceMail(){
		return new SendMailClass(); 
	}
	
	public SendInterface ProduceSms(){
		return new SendSmsClass();
	}
}
