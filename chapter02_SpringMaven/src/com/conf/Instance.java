package com.conf;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import sample03.SungJukDTO;
import sample03.SungJukImpl;
import sample05.SungJukDTO2;
import sample05.SungJukDelete;
import sample05.SungJukInput;
import sample05.SungJukModify;
import sample05.SungJukOutput;

//환경설정으로 잡는 클래이스다. 라고 알려주는것이다
@Configuration
public class Instance {
	
	// 빈  = 리턴되서 나오는 값을 생성해줘라
	//sample03
	@Bean(name="sungJukImpl")
	public SungJukImpl getSungJukImpl() {
		return new SungJukImpl();
	}
	@Bean(name="sungJukDTO")
	public SungJukDTO getSungJukDTO(){
		return new SungJukDTO();
	}
	
	//sample05
	@Scope("prototype")
	@Bean(name="sungJukDTO2")
	public SungJukDTO2 getSungJukDTO2(){
		return new SungJukDTO2();
	}
	@Bean(name="arrayList")
	public ArrayList<SungJukDTO2> getList(){
		return new ArrayList<SungJukDTO2>();
	}
	@Bean(name="sungJukOutput")
	public SungJukOutput getSungJukOutput() {
		return new SungJukOutput();
	}
	@Bean(name="sungJukDelete")
	public SungJukDelete getSungJukDelete() {
		return new SungJukDelete();
	}
	@Bean(name="sungJukModify")
	public SungJukModify getSungJukModify() {
		return new SungJukModify();
	}
	@Scope("prototype")
	@Bean(name="sungJukInput")
	public SungJukInput getSungJukInput() {
		return new SungJukInput();
	}
//	@bean @component 의 차이를 알고있어라
}
