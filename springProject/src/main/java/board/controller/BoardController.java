package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.service.BoardService;
import net.sf.json.JSONArray;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board/boardWriteForm" , method=RequestMethod.GET)
	public ModelAndView boardWriteForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("display","/board/boardWriteForm.jsp");
		mav.setViewName("/main/index");
		return mav;
	}
	
	@RequestMapping(value="/board/boardWrite" , method=RequestMethod.POST)
	public void boardWrite(@RequestParam Map<String, String> map,
							HttpSession session) {
		
		String id = (String)session.getAttribute("memId");
		String name =(String)session.getAttribute("memName");
		String email = (String)session.getAttribute("memEmail");
		
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		
		boardService.boardWrite(map);
	}
	
	@RequestMapping(value="/board/boardList" , method=RequestMethod.GET)
	public ModelAndView boardList() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("display","/board/boardList.jsp");
		mav.setViewName("/main/index");
		return mav;
	}
	
	@RequestMapping(value="/board/writeAll" , method=RequestMethod.POST)
	public ModelAndView writeAll(@RequestParam String pg) {
		int endNum = Integer.parseInt(pg) * 5; //한페이지당 5개
		int startNum = endNum - 4;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		List<BoardDTO> list = boardService.writeAll(map);
//		System.out.println("list" + list);
//		JSONArray jsonArray =  JSONArray.fromObject(list);
//		Map을 통해서 list에 이름을 부여
//		map.put("list", jsonArray);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
		
	}
	
	
	
	
	
}
