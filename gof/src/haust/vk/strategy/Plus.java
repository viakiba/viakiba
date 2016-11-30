package haust.vk.strategy;

public class Plus extends AbstractCalculator implements ICalculator {

	@Override
	public int calculate(String exp) {
		int array[] = spilt(exp, "\\+");
		return array[0]+array[1];
	}

}
