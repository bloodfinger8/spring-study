package sample05;

import java.util.ArrayList;
import java.util.Scanner;

import lombok.Setter;

@Setter
public class SungJukDelete implements SungJuk{
	private ArrayList<SungJukDTO> list;
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제하고자 하는 이름 입력");
		String name = scan.next();
		int sw=0;
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getName().equals(name)) {
				list.remove(i);
				sw++;
			}
		}
//		Iterator<SungJukDTO> it = list.iterator();
//		while(it.hasNext()) {
//			if(it.next().getName().equals(name)) {
//				it.remove();
//				sw++;
//			}
		
		if(sw==0) {
			System.out.println("입력하신 이름이 존재하지 않습니다.");
		}else {
			System.out.println("삭제 완료");
		}
		
		
	}

}
