package haust.vk.tongxin.ProCoum;

public class Demo {
	public static void main(String[] args) {
		Person p = new Person();
		
		new Thread(new Producer(p)).start();
		new Thread(new Consumer(p)).start();
	}
}
