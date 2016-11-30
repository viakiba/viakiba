package haust.vk.adapter.a_adapter;

public class App {
	public static void main(String[] args) {
		Targetable target = new Adapter();
		target.method1();
		target.method2();
	}
}
