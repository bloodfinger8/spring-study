package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Calc calc;
		calc = (Calc)context.getBean("calc");
		calc.calculate(25, 36);
		
		calc =context.getBean("calc2" , Calc.class);
		calc.calculate(25, 36);
		
		((AbstractApplicationContext)context).close();
	}

}
