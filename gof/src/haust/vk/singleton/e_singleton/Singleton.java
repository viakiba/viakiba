package haust.vk.singleton.e_singleton;

import java.util.Vector;

public class Singleton {
	private static Singleton instance = null;  
    private Vector properties = null;  
  
    public Vector getProperties() {  
    	//这里实现属性的动态更新  操作数据库 实现
        return properties;  
    }  
  
    private Singleton() {  
    }  
  
    private static synchronized void syncInit() {  
        if (instance == null) {  
            instance = new Singleton();  
        }  
    }  
  
    public static Singleton getInstance() {  
        if (instance == null) {  
            syncInit();  
        }  
        return instance;  
    }  
  
    public void updateProperties() {  
        Singleton shadow = new Singleton();  
        properties = shadow.getProperties();  
    }  
}
