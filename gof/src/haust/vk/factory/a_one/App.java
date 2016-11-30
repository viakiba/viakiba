package haust.vk.factory.a_one;

public class App {
	public static void main(String[] args) {
		SendFactory sendInterface = new SendFactory();
		SendInterface send = sendInterface.Produce("mail1");
		send.Send();
	}
}
