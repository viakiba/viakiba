package haust.vk.decorator;

public class App {
	public static void main(String[] args) {
		Sourceable source = new Source();  
        Sourceable obj = new Decorator(source);  
        obj.method();
	}
}
