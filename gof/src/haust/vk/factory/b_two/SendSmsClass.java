package haust.vk.factory.b_two;

public class SendSmsClass implements SendInterface{
	@Override
	public void send() {
		System.out.println("通过短信发出");
	}
}
