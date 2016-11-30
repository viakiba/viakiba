package haust.vk.adapter.c_adapter;

public class App {
	public static void main(String[] args) {
		Sourceable source1 = new SourceSub1();  
        Sourceable source2 = new SourceSub2();  
          
        source1.method1();  
        source1.method2();  
        source2.method1();  
        source2.method2();  
	}
}
