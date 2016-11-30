package haust.vk.factory.b_two;

public class SendMailClass implements SendInterface{
	@Override
	public void send() {
		System.out.println("通过邮件发出");
	}
}
