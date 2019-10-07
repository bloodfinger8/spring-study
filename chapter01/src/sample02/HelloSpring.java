package sample02;

public class HelloSpring {

	public static void main(String[] args) {
		//부모 = 자식  -> 다형성
		MessageBean messageBean;
		messageBean = new MessageBeanKo();
		//messageBean = new MessageBeanEn();
		messageBean.sayHello("spring");
		
		
//		1대1, 결합도 100%
//		MessageBeanKo aa = new MessageBeanKo();
		
	}

}
