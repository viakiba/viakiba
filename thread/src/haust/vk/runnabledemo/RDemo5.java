package haust.vk.runnabledemo;

class SellDemo implements Runnable{
	private int num = 50;
	@Override
	public void run() {
		for (int i = 0; i < 200; i++) {
		
				if(num > 0){	
					try {
					//因为它不可以直接调用getName()方法，所以必须要获取当前线程。
						new Thread(new SellDemo(),"sa").join();
						System.out.println(Thread.currentThread().getName()+"卖出第"+ num-- +"张票！");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		}
	}
}

public class RDemo5 {
	public static void main(String[] args) {
		SellDemo s = new SellDemo();
		new Thread(s,"A").start();
		new Thread(s,"B").start();
		new Thread(s,"C").start();
		new Thread(s,"D").start();
	}
}

