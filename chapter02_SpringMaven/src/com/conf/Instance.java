package com.conf;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample03.SungJukDTO;
import sample03.SungJukImpl;

//환경설정으로 잡는 클래이스다. 라고 알려주는것이다
@Configuration
public class Instance {
	
	// 빈  = 리턴되서 나오는 값을 생성해줘라
	@Bean(name="sungJukImpl")
	public SungJukImpl getSungJukImpl() {
		return new SungJukImpl();
	}
	
	@Bean(name="sungJukDTO")
	public SungJukDTO getSungJukDTO() {
		return new SungJukDTO();
	}
	
	@Bean(name="list")
	public ArrayList<SungJukDTO> getList(){
		return new ArrayList<SungJukDTO>();
	}
//	@bean @component 의 차이를 알고있어라
}
