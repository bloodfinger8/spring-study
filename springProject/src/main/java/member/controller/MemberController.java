package member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;
import member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/member/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(@RequestParam String id, @RequestParam String pwd, HttpSession session) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		MemberDTO memberDTO = memberService.login(map);
		
		String loginResult = null;
		if(memberDTO != null) {
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memId", id);
			session.setAttribute("memEmail", memberDTO.getEmail1() + "@" + memberDTO.getEmail2());
			loginResult="success";
		}else {
			loginResult="fail";
		}
		return loginResult;
	}
	
	@RequestMapping(value="/member/logout" , method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "/member/logout";
	}
	
	@RequestMapping(value="/member/writeForm" , method=RequestMethod.GET)
	public ModelAndView writeForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("display","/member/writeForm.jsp");
		mav.setViewName("/main/index");
		return mav;
	}
	
	@RequestMapping(value="/member/checkId" , method=RequestMethod.POST)
	@ResponseBody
	public String checkId(@RequestParam String id) {
		MemberDTO memberDTO = memberService.isExistId(id);
		if(memberDTO == null) {
			return "fail"; //아이디가 존재하지 않을때
		}else {
			return "success"; //아이디가 존재 할때
		}
	}
	
	@RequestMapping(value="/member/getZipcodeList" , method=RequestMethod.POST)
	public ModelAndView getZipcodeList(@RequestParam String sido,
									   @RequestParam String sigungu,
									   @RequestParam String roadname) {
		
		System.out.println(sido + " " + sigungu + " " + roadname);
		ModelAndView mav = new ModelAndView();
		
		List<ZipcodeDTO> list = null;
		if(sido != "" && roadname!= ""){ //데이터가 없으면 못가게 한다
			Map<String, String> map = new HashMap<String, String>();
			map.put("sido", sido);
			map.put("sigungu", sigungu);
			map.put("roadname", roadname);
			list = memberService.getZipcodeList(map);
		}
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
	}
	
	
}
