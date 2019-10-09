package sample05;

import java.util.Scanner;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.conf")
public class SungJukModify implements SungJuk {

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println("수정하고자 하는 이름 입력");
		String name = scan.next();
		int sw=0;
		
		for(int i=0;i<HelloSpring.list.size();i++) {
			if(HelloSpring.list.get(i).getName().equals(name)) {
				System.out.println("이름 입력 : ");
				HelloSpring.list.get(i).setName(scan.next());
				System.out.println("국어 점수 입력 : ");
				HelloSpring.list.get(i).setKor(scan.nextInt());
				System.out.println("영어 점수 입력 : ");
				HelloSpring.list.get(i).setEng(scan.nextInt());
				System.out.println("수학 점수 입력 : ");
				HelloSpring.list.get(i).setMath(scan.nextInt());
				sw++;
			}
		}
		if(sw==0) {
			System.out.println("입력하신 이름이 존재하지 않습니다.");
		}else {
			System.out.println("수정 완료");
		}
	}

}
