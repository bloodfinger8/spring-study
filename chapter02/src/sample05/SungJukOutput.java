package sample05;

import java.util.ArrayList;

import lombok.Setter;

@Setter
public class SungJukOutput implements SungJuk{
	private ArrayList<SungJukDTO> list;
	
	
	
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
