package haust.vk.threadDemo;
class MyThread extends Thread{
	private String name;
	public MyThread(String name){
		this.name = name;
	}
	
	public void run(){
		for(int i = 0; i<50 ; i++){
			System.out.println(name+"第"+i+"次售票");
		}
	}
}
public class TDemo2 {
	public static void main(String[] args) {
		new MyThread("A").start();
		new MyThread("撒").start();
		new MyThread("放到").start();
		
	}
}
