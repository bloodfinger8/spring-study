package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample02.Calc;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SungJukImpl sungJukImpl = (SungJukImpl)context.getBean("sungJukImpl");
		sungJukImpl.calcTot();
		sungJukImpl.calcAvg();
		sungJukImpl.display();
		
		System.out.println("수정");
		sungJukImpl.modify();
		sungJukImpl.calcTot();
		sungJukImpl.calcAvg();
		sungJukImpl.display();
	}

}
