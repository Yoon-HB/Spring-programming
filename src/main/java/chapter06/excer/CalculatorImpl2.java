package chapter06.excer;

public class CalculatorImpl2 implements Calculator {

	@Override
	public long factorial(int num) {
		// 재귀호출 10 -> 10 * (9 * (8)
		if (num == 0) {
			return 1;
		}
		return num * factorial(num-1);
		
	}

}
