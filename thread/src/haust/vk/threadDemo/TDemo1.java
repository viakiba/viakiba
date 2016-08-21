package haust.vk.threadDemo;

public class TDemo1 extends Thread{
	String name;
	public TDemo1(String name){
		super();
		this.name = name;
	}
	

	public void run(){
		System.out.println(name+"Æô¶¯");
	}
	
}
