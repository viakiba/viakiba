package haust.vk.visitor;

public class App {
	public static void main(String[] args) {
	        Visitor visitor = new MyVisitor();  
	        Subject sub = new MySubject();  
	        sub.accept(visitor);      
	}
}
