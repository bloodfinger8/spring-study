package sample05;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class SungJukDelete implements SungJuk{

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제하고자 하는 이름 입력");
		String name = scan.next();
		int sw=0;
		
		for(int i=0;i<HelloSpring.list.size();i++) {
			if(HelloSpring.list.get(i).getName().equals(name)) {
				HelloSpring.list.remove(i);
				sw++;
			}
		}
		if(sw==0) {
			System.out.println("입력하신 이름이 존재하지 않습니다.");
		}else {
			System.out.println("삭제 완료");
		}
//		for(SungJukDTO sungJukDTO : HelloSpring.list) {
//			if(sungJukDTO.getName().equals(name)) {
//				HelloSpring.list.remove(sungJukDTO);
//			}
//		}
		
		
	}

}
