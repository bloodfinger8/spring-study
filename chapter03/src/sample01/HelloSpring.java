package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("acQuickStart.xml");
		MessageBean messageBean = (MessageBean) context.getBean("messageBeanImpl");
//		messageBean.showPrintBefore();
//		System.out.println("----------------------");
//		messageBean.viewPrintBefore();
//		System.out.println("----------------------");
//		messageBean.display(); //대상자가 포인트컷이 아니기 때문에 안들어온다
		
//		messageBean.showPrintAfter();
//		System.out.println("----------------------");
//		messageBean.viewPrintAfter();
//		System.out.println("----------------------");
//		messageBean.display(); //대상자가 포인트컷이 아니기 때문에 안들어온다
		
		messageBean.showPrint();
		System.out.println("----------------------");
//		messageBean.viewPrint();
//		System.out.println("----------------------");
//		messageBean.display(); //대상자가 포인트컷이 아니기 때문에 안들어온다
	}

}
