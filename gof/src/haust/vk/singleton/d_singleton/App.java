package haust.vk.singleton.d_singleton;

public class App {
	public static void main(String[] args) {
		Singleton instance = Singleton.getInstance();
		System.out.println(instance.toString());
	}
}
