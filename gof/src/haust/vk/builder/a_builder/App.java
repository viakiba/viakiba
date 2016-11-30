package haust.vk.builder.a_builder;

import java.util.List;

public class App {
	public static void main(String[] args) {
		Builder builder = new Builder();
		builder.produceMailSender(10);
		List<SendInterface> list = builder.getList();
		SendInterface sendInterface = list.get(2);
		sendInterface.Send();
	}
}
