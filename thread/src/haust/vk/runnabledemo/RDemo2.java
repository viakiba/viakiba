package haust.vk.runnabledemo;

class SellTicket extends Thread{
	private String name;
	private int num = 50;
	public SellTicket(String name) {
		super();
		this.name = name;
	}
	
	public void run(){
		for (int i = 1; i <= num; i++) {
			System.out.println(name+"卖出了第"+i+"张票！");
		}
	}
}

class MySell implements Runnable{
	private int num = 50;
	
	@Override
	public void run() {
		for (int i = 1; i <= num; i++) {
			System.out.println(Thread.currentThread().getName()+"卖出了第"+i+"张票！");
		}
	}
}

public class RDemo2 {
	public static void main(String[] args) throws Exception {
		
		new SellTicket("A").start();
		new SellTicket("B").start();
		new SellTicket("C").start();
		
		new Thread(new MySell(),"D").start();
		new Thread(new MySell(),"E").start();
		new Thread(new MySell(),"F").start();
		
		
	}
}

