package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//컨드롤러가 컴퍼넌트 기능까지 한다
@Controller
public class HelloController {
	@RequestMapping(value="/hello.do",method=RequestMethod.GET)
	public ModelAndView hello() { //콜백 메소드이다, 오버로드가 안된다
		ModelAndView mav = new ModelAndView();
		mav.addObject("result","Hello Spring^*^!!~");
		//mav.setViewName("hello");
		mav.setViewName("/view/hello");
		return mav;
	}
}

