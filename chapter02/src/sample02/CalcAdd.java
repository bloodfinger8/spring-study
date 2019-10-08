package sample02;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CalcAdd implements Calc {
	private int a , b;
	
	@Override
	public void calculate() {
		System.out.println( a + " + " + b + " = " +(a+b));
	}

}
