package sample05;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.conf")
public class SungJukOutput implements SungJuk{

	@Override
	public void execute() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		for(int i=0;i<HelloSpring.list.size();i++){
		    System.out.println(HelloSpring.list.get(i).getName()
		    				   +"\t"+HelloSpring.list.get(i).getKor()
		    				   +"\t"+HelloSpring.list.get(i).getEng()
		    				   +"\t"+HelloSpring.list.get(i).getMath()
		    				   +"\t"+HelloSpring.list.get(i).getTot()
		    				   +"\t"+HelloSpring.list.get(i).getAvg());
		}
	}

}
