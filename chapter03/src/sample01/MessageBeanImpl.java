package sample01;

import lombok.Setter;

//target 클래스
@Setter
public class MessageBeanImpl implements MessageBean {
	private String str;
	private String LoggingAdvice;
	
	@Override
	public void showPrintBefore() {
		System.out.println("showPrintBefore 메세지 = " + str);
	}
	@Override
	public void viewPrintBefore() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintBefore 메세지 = " + str);
	}
	
	
	@Override
	public void showPrintAfter() {
		System.out.println("showPrintAfter 메세지 = " + str);
	}
	@Override
	public void viewPrintAfter() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintAfter 메세지 = " + str);
	}
	
	@Override
	public String showPrint() {
		System.out.println("showPrint 메세지 = " + str);
		return "SPRING AOP";
	}
	@Override
	public void viewPrint() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrint 메세지 = " + str);
	}
	
	@Override
	public void display() {
		System.out.println("display 메세지 = " + str);
	}
	
}
