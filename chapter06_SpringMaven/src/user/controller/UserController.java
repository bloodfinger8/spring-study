package user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import user.bean.UserDTO;
import user.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value="/user/writeForm.do",method=RequestMethod.GET)
	public String writeForm() { 
		return "/user/writeForm";
	}
	
	
	@RequestMapping(value="/user/write" , method=RequestMethod.POST)
	@ResponseBody
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}
	
	@RequestMapping(value="/user/list" , method=RequestMethod.GET)
	public String list() {
		return "/user/list";
	}
	
	@RequestMapping(value="/user/getList" , method=RequestMethod.POST)
	public ModelAndView getList() {
		List<UserDTO> list = userService.getList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list" , list);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="/user/modifyForm" , method=RequestMethod.GET)
	public String modifyForm() { 
		return "/user/modifyForm";
	}
	
	@RequestMapping(value="/user/getUser" , method=RequestMethod.GET)
	public ModelAndView getUser(@RequestParam String id) {
		UserDTO userDTO = userService.getUser(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("userDTO" , userDTO);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="/user/getModify" , method=RequestMethod.POST)
	@ResponseBody
	public void getModify(@ModelAttribute UserDTO userDTO) {
		userService.getModify(userDTO);
	}
	
	@RequestMapping(value="/user/deleteForm" , method=RequestMethod.GET)
	public String deleteForm() {
		return "/user/deleteForm";
	}
	
	@RequestMapping(value="/user/userDelete" , method=RequestMethod.POST)
	@ResponseBody
	public void userDelete(@RequestParam String id) {
		System.out.println("id = "  + id);
		userService.userDelete(id);
	}
	
	
}
