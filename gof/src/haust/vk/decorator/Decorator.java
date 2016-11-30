package haust.vk.decorator;

public class Decorator implements Sourceable {
	private Sourceable sourceable;
	
	public Decorator(Sourceable source){
		super();
		this.sourceable = source;
	}
	
	@Override
	public void method() {
		System.out.println("before decorator!");  
		sourceable.method();  
        System.out.println("after decorator!");
	}

}
