package haust.vk.singleton.b_singleton;

public class Singleton {
	private static Singleton instance = null ;
	private Singleton(){};
	public static synchronized Singleton getInstance(){
		if( instance == null){
			instance = new Singleton();
		}
		return instance;
	}
	
}
