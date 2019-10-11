package sample05;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;

//@Component
@ComponentScan("com.conf")
public class SungJukOutput implements SungJuk{
	@Qualifier("list")
	@Autowired
	private List<SungJukDTO2> list;
	
	
	@Override
	public void execute() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		for(int i=0;i<list.size();i++){
		    System.out.println(list.get(i).getName()
		    				   +"\t"+list.get(i).getKor()
		    				   +"\t"+list.get(i).getEng()
		    				   +"\t"+list.get(i).getMath()
		    				   +"\t"+list.get(i).getTot()
		    				   +"\t"+list.get(i).getAvg());
		}
	}

}
