package haust.vk.factory.a_one;

public class SendMailClass implements SendInterface{
	@Override
	public void Send() {
		System.out.println("通过邮件发出");
	}
}
