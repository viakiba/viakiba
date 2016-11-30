package haust.vk.singleton.c_singleton;

public class Singleton {
	private static Singleton instance ;
	private Singleton(){};
	public static Singleton getInstance(){
		if(instance == null){//线程安全；延迟加载；效率较高。
			synchronized (Singleton.class) {
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		
		return instance;
	}
	
	public static void Test(){
		System.out.println("测试");
	}
}
