package haust.vk.factory.c_three;

public class SendMailFactory implements SendFactory{
	@Override
	public Send getSend() {
		return new SendMailClass();
	}
}
