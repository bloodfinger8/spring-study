package sample05;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@ComponentScan("com.conf")
@Data
public class SungJukDTO2 {
	private String name;
	private int kor,eng,math,tot;
	private double avg;
	
	
}
