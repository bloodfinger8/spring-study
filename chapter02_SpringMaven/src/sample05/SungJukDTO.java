package sample05;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class SungJukDTO {
	private String name;
	private int kor,eng,math,tot;
	private double avg;
	
	
}
