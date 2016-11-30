package haust.vk.singleton.d_singleton;

public class Singleton {
	private Singleton() {
	}
	
	private static class SingletonFactory{
		private static Singleton instance = new Singleton();
	}
	
	 /* 获取实例 */  
    public static Singleton getInstance() {  
        return SingletonFactory.instance;  
    }  
  
    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
    public Object readResolve() {  
        return getInstance();  
    }  
}
