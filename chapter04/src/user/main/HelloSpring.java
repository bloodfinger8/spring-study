package user.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.service.UserService;

public class HelloSpring {
	public void menu(ApplicationContext context) {
		Scanner scan = new Scanner(System.in);
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		int input;
		
		while(true) {
			System.out.println("*************");
			System.out.println("1.입력");
			System.out.println("2.출력");
			System.out.println("3.수정");
			System.out.println("4.삭제");
			System.out.println("5.종료");
			System.out.println("*************");
			input = scan.nextInt();
			
			UserService userService;
			if(input == 1){
				userService = (UserService)context.getBean("userInsertService");
				userService.execute();
			}else if(input == 2) {
				userService = (UserService)context.getBean("userSelectService");
				userService.execute();
			}else if(input == 3) {
				userService = (UserService)context.getBean("userUpdateService");
				userService.execute();
			}else if(input == 4) {
				userService = (UserService)context.getBean("userDeleteService");
				userService.execute();
			}else {
				break;
			}
		}
		
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		HelloSpring helloSpring = (HelloSpring)context.getBean("helloSpring");
		helloSpring.menu(context);
		System.out.println("프로그램을 종료");
	}
}
