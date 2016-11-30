package haust.vk.factory.b_two;

public class App {
	public static void main(String[] args) {
		SendFactory sendFactory = new SendFactory();
		SendInterface send = sendFactory.ProduceMail();
		SendInterface produceSms = sendFactory.ProduceSms();
		
		send.send();
		produceSms.send();
	}
}
