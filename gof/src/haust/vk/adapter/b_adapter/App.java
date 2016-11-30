package haust.vk.adapter.b_adapter;

public class App {
	public static void main(String[] args) {
		Source source = new Source();
		Targetable target = new Adapter(source);
		target.method1();
		target.method2();
	}
}
