package haust.vk.factory.c_three;

public class SendSmsFactory implements SendFactory{
	@Override
	public Send getSend() {
		return new SendSmsClass();
	}
}
