package haust.vk.factory.c_three;

public class SendMailClass implements Send{
	@Override
	public void Send() {
		System.out.println("通过邮件发送");
	}
}
