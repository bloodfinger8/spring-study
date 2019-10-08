package sample03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

//@Component
@ComponentScan("com.conf")
@Setter
@Getter
public class SungJukDTO{
	@Value("홍길동")
	private String name;
	@Value("97")
	private int kor;
	@Value("100")
	private int eng;
	@Value("95")
	private int math;
	private int tot;
	private double avg;
	
	
	@Override
	public String toString() {
		return name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+tot+"\t"+String.format("%.3f", avg);
	}
	
}
