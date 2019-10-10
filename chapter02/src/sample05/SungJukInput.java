package sample05;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.Setter;

@Setter
public class SungJukInput implements SungJuk {
	private SungJukDTO sungJukDTO;
	private ArrayList<SungJukDTO> list; 
	
	public void setSungJukDTO(SungJukDTO sungJukDTO) {
		this.sungJukDTO = sungJukDTO;
	}
	
	@Override
	public void execute() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		SungJukDTO sungJukDTO = (SungJukDTO)context.getBean("sungJukDTO");
		
		//데이터 입력
		Scanner scan = new Scanner(System.in);
		System.out.println("이름 입력 : ");
		String name = scan.next();
		
		//list에 동일한 이름이 있는지 체크
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getName().equals(name)) {
				System.out.println("동일한 이름 존재");
				return;
			}
		}
		sungJukDTO.setName(name);
		System.out.println("국어 점수 입력 : ");
		sungJukDTO.setKor(scan.nextInt());
		System.out.println("영어 점수 입력 : ");
		sungJukDTO.setEng(scan.nextInt());
		System.out.println("수학 점수 입력 : ");
		sungJukDTO.setMath(scan.nextInt());
		
		//데이터 계산
		sungJukDTO.setTot(sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath());
		sungJukDTO.setAvg(sungJukDTO.getTot() / 3.0);
		//데이터 저장
		list.add(sungJukDTO);
	}

}
