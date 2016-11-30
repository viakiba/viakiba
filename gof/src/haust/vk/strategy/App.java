package haust.vk.strategy;

public class App {
	public static void main(String[] args) {
		String exp = "2*8";
		ICalculator cal =  new Multiply();
		int res = cal.calculate(exp);
		System.out.println(res);
	}
}
