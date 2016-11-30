package haust.vk.singleton.a_singleton;

public class Singleton {
	private static Singleton instance = null;
	
	private Singleton(){}
	
	/**
	 * 创建实例
	 */
	public static Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}
	
	public static void Test(){
		System.out.println("测试");
	}
	/**
	 *  如果该对象被用于序列化，可以保证对象在序列化前后保持一致 
	 */  
    public Object readResolve() {  
        return instance;  
    }  
}
