package com.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SumDTO;

import lombok.Setter;

@Controller
public class SumController {
	@Setter
	private SumDTO sumDTO;
	
	
//	@RequestMapping(value="/input.do",method=RequestMethod.GET)
//	public ModelAndView input() { //콜백 메소드이다, 오버로드가 안된다
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/sum/input");
//		return mav;
//	}
	
	@RequestMapping(value="/input.do",method=RequestMethod.GET)
	//리턴타입이 String 이면 단순 문자열이 아니라 view의 이름으로 인식합니다.!
	//뷰의 이름이 아니라 단순 문자열로 return 하려면 @ResponseBody를 사용해야 한다.
	public String input() { 
		return "/sum/input";
	}
	
//	@RequestMapping(value="/result.do",method=RequestMethod.GET)
//	public ModelAndView result(@RequestParam("x") String x, @RequestParam("y") String y) { //콜백 메소드이다, 오버로드가 안된다
//		ModelAndView mav = new ModelAndView();
//		sumDTO.setX(Integer.parseInt(x));
//		sumDTO.setY(Integer.parseInt(y));
//		mav.addObject(sumDTO);
//		mav.setViewName("/sum/result");
//		return mav;
//	}
	
//	@RequestMapping(value="/result.do",method=RequestMethod.GET)
//	public ModelAndView result(@RequestParam("x") int x, @RequestParam("y") int y) { //콜백 메소드이다, 오버로드가 안된다
//		ModelAndView mav = new ModelAndView();
//		sumDTO.setX(x);
//		sumDTO.setY(y);
//		mav.addObject(sumDTO);
//		mav.setViewName("/sum/result");
//		return mav;
//	} int형으로 받으면 넘버포멧 에러가 뜰수있기때문에
	
	
//	@RequestMapping(value="/result.do",method=RequestMethod.GET)
//	public ModelAndView result(@RequestParam(required=false, defaultValue="0") String x, 
//							   @RequestParam(required=false, defaultValue="0") String y) { //콜백 메소드이다, 오버로드가 안된다
//		ModelAndView mav = new ModelAndView();
//		sumDTO.setX(Integer.parseInt(x));
//		sumDTO.setY(Integer.parseInt(y));
//		mav.addObject(sumDTO);
//		mav.setViewName("/sum/result");
//		return mav;
//	}
	
//	@RequestMapping(value="/result.do",method=RequestMethod.GET)
//	public String result(@RequestParam Map<String, String> map  , ModelMap modelMap) { //콜백 메소드이다, 오버로드가 안된다
//		sumDTO.setX(Integer.parseInt(map.get("x")));
//		sumDTO.setY(Integer.parseInt(map.get("y")));
//		modelMap.put("sumDTO", sumDTO);
//		return "/sum/result";
//	}
	
	@RequestMapping(value="/result.do",method=RequestMethod.GET)
	public String result(@ModelAttribute SumDTO sumDTO , Model model) { //콜백 메소드이다, 오버로드가 안된다
		model.addAttribute("sumDTO", sumDTO);
		return "/sum/result";
	}
	
	
}
