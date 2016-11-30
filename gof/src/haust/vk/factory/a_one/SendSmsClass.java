package haust.vk.factory.a_one;

public class SendSmsClass implements SendInterface{
	@Override
	public void Send() {
		System.out.println("通过短信发出");
	}
}
