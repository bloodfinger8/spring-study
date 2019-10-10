package sample05;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class HelloSpring {
	
	public void manu() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("*************");
			System.out.println("1.입력");
			System.out.println("2.출력");
			System.out.println("3.수정");
			System.out.println("4.삭제");
			System.out.println("5.종료");
			System.out.println("*************");
			int input = scan.nextInt();
			
			SungJuk sungJuk;
			if(input == 1) {
				sungJuk = (SungJukInput)context.getBean("sungJukInput");
				sungJuk.execute();
			}else if(input == 2) {
				sungJuk = (SungJukOutput)context.getBean("sungJukOutput");
				sungJuk.execute();
			}else if(input == 3) {
				sungJuk = (SungJukModify)context.getBean("sungJukModify");
				sungJuk.execute();
			}else if(input == 4) {
				sungJuk = (SungJukDelete)context.getBean("sungJukDelete");
				sungJuk.execute();
			}else if(input == 5) {
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
		System.out.println("종료 합니다");
		
	}
}
