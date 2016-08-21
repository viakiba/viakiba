package haust.vk.runnabledemo;

class MyRunnable implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<50; i++){
			System.out.println(Thread.currentThread().getName()+"µÚ"+i+"´ÎÊÛÆ±");
		}
	}
	
}
public class RDemo3 {
	public static void main(String[] args) {
		new Thread(new MyRunnable(),"A").start();
		new Thread(new MyRunnable(),"B").start();
		new Thread(new MyRunnable(),"C").start();
	}
}
