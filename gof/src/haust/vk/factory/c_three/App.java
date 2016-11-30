package haust.vk.factory.c_three;

public class App {
	public static void main(String[] args) {
		SendFactory sendFactory = new SendMailFactory();
		sendFactory.getSend().Send();
	}
}
