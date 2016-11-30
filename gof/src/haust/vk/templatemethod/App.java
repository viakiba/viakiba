package haust.vk.templatemethod;

public class App {
	public static void main(String[] args) {
		Plus p = new Plus();
		int i = p.calculate("8+25", "\\+");
		System.out.println(i);
	}
}
