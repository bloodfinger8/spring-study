package sample05;

import lombok.Data;

@Data
public class SungJukInput implements SungJuk {
	private SungJukDTO sungJukDTO;
	
	

	@Override
	public void execute() {
		
	}

}
