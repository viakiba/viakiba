package haust.vk.runnabledemo;

public class RDemo1  implements Runnable{
	private String name;
	public RDemo1(String name){
		super();
		this.name = name;
	}
	
	@Override
	public void run() {
		for(int i = 0 ; i < 50 ; i++){
			System.out.println(Thread.currentThread().getName() + "µÚ"+i+"´Î");
		}
	}
}
