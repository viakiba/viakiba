package haust.vk.factory.c_three;

public class SendSmsClass implements Send{
	@Override
	public void Send() {
		System.out.println("通过短信发送");
	}
}
