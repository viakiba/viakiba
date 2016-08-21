package haust.vk.runnabledemo;

class SellDemo2 implements Runnable{
	private int num = 503;
	@Override
	public void run() {
		for (int i = 0; i < 200; i++) {//一个程序调用200下
			/*synchronized (this) {
				if(num > 0){	
					try {
					//因为它不可以直接调用getName()方法，所以必须要获取当前线程。
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				System.out.println(Thread.currentThread().getName()+"卖出第"+num--+"张票！");
				}*/
			gen();
			}
		}
	public synchronized  void gen(){
		synchronized (this) {
			if(num > 0){	
				try {
				//因为它不可以直接调用getName()方法，所以必须要获取当前线程。
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			System.out.println(Thread.currentThread().getName()+"卖出第"+num--+"张票！");
			}
	}
}
}
public class RDemo6 {
	public static void main(String[] args) {
		SellDemo2 s = new SellDemo2();
		new Thread(s,"A").start();
		new Thread(s,"B").start();
		new Thread(s,"C").start();
	}
}

