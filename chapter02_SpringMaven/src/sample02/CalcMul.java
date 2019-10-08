package sample02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CalcMul implements Calc {
//	private @Value("25") int a;
//	private @Value("36") int b;
	private int a,b;
	
	@Autowired
	public void setA(@Value("25") int a) {
		this.a = a;
	}
	
	@Autowired
	public void setB(@Value("36") int b) {
		this.b = b;
	}
	
	//생성자는 바로 호출이 되지만 셋터는 안되기때문에 spring이 자동처리하게 해줘야 한다 그래서 Autowired 어노테이션을 쓴다.

	@Override
	public void calculate() {
		System.out.println( a + " * " + b + " = " + (a*b));
	}

}
