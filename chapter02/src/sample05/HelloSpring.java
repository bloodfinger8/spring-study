package sample05;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HelloSpring {
//	ArrayList list = new ArrayList(); com.conf로 잡지 못한다면 이렇게 써라
	
	public void manu() {
		Scanner scan = new Scanner(System.in);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		while(true) {
			System.out.println("1.입력");
			System.out.println("2.출력");
			System.out.println("3.수정");
			System.out.println("4.삭제");
			System.out.println("5.종료");
			int input = scan.nextInt();
			if(input == 1) {
				SungJukInput sungJukInput = (SungJukInput)context.getBean("sungJukInput");
				sungJukInput.execute();
			}else if(input == 2) {
				SungJukOutput sungJukOutput = (SungJukOutput)context.getBean("sungJukOutput");
				sungJukOutput.execute();
			}else if(input == 3) {
				SungJukModify sungJukModify = (SungJukModify)context.getBean("sungJukModify");
				sungJukModify.execute();
			}else if(input == 4) {
				SungJukDelete sungJukDelete = (SungJukDelete)context.getBean("sungJukDelete");
				sungJukDelete.execute();
			}else if(input == 5) {
				System.out.println("종료 합니다");
				break;
			}else {
				System.out.println("1~5까지 입력하세요");
			}
		}
	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloSpring helloSpring = (HelloSpring)context.getBean("helloSpring");
		helloSpring.manu();
		
		
	}
}
