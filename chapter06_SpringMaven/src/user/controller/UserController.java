package user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
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
	
//	@RequestMapping(value="/user/getList" , method=RequestMethod.POST)
//	public ModelAndView getList() {
//		List<UserDTO> list = userService.getList();
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("list" , list);
//		mav.setViewName("jsonView");
//		return mav;
//	}
	//자바파일에서
	@RequestMapping(value="/user/getList" , method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getList() {
		List<UserDTO> list = userService.getList();
		
		JSONArray jsonArray =  JSONArray.fromObject(list);
		//Map을 통해서 list에 이름을 부여
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", jsonArray);
		
		return map;
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
	
	@RequestMapping(value="/user/checkId", method=RequestMethod.POST)
	@ResponseBody
	public String checkId(@RequestParam String id) {
		UserDTO userDTO = userService.checkId(id);
		
		if(userDTO==null)
			return "not_exist";
		else
			return "exist";
	}
	
	@RequestMapping(value="/user/search" , method=RequestMethod.POST)
	public ModelAndView search(@RequestBody Map<String, String> inputMap) {
		System.out.println("map " + inputMap );
		
		List<UserDTO> list  = userService.search(inputMap);
		System.out.println("list" + list);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
		
	}
	
	
	
}
