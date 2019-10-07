package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class HelloSpring{

	public static void main(String[] args) {
		//ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MessageBean bean = (MessageBean)context.getBean("messageBean");
		bean.sayHello("spring");
		System.out.println();
		
		MessageBean bean2 = (MessageBean)context.getBean("messageBean");
		bean2.sayHello("spring");
		System.out.println();
		
		MessageBean bean3 = (MessageBean)context.getBean("messageBean");
		bean3.sayHello("spring");
		System.out.println();
		
		//num은 원래 1이 나와야 하지만 자체적으로 싱글톤으로 잡혀있기때문에 2, 3이 나온다
	}

}
