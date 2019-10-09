package sample05;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@ComponentScan("com.conf")
public class HelloSpring {
	//ArrayList list = new ArrayList(); com.conf로 잡지 못한다면 이렇게 써라
	//static ArrayList<SungJukDTO> list = new ArrayList<SungJukDTO>();
	@Autowired
	static ArrayList<SungJukDTO> list;
	
	
	public void manu() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("********************");
			System.out.println("1.입력");
			System.out.println("2.출력");
			System.out.println("3.수정");
			System.out.println("4.삭제");
			System.out.println("5.종료");
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
