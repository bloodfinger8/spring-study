package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.service.BoardService;
import net.sf.json.JSONArray;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private BoardPaging boardPaging;
	
	
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
	public ModelAndView boardList(@RequestParam(required=false, defaultValue="1") String pg) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg" , pg);
		mav.addObject("display","/board/boardList.jsp");
		mav.setViewName("/main/index");
		return mav;
	}
	
	@RequestMapping(value="/board/writeAll" , method=RequestMethod.POST)
	public ModelAndView writeAll(@RequestParam String pg ,HttpSession session) {
		int endNum = Integer.parseInt(pg) * 5; //한페이지당 5개
		int startNum = endNum - 4;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		List<BoardDTO> list = boardService.writeAll(map);
		
		//페이징 처리
		int totalA = boardService.getTotalA();
		boardPaging.setCurrentPage(Integer.parseInt(pg));
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();
		
		
		String memId = (String)session.getAttribute("memId");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("memId" , memId);
		mav.addObject("list", list);
		mav.addObject("boardPaging", boardPaging);
		mav.setViewName("jsonView");
		return mav;
		
	}
	
	@RequestMapping(value="/board/boardView" , method=RequestMethod.GET)
	public ModelAndView boarView(@RequestParam String seq,
								 @RequestParam String pg,
								 HttpSession session) {
		BoardDTO boardDTO= boardService.getBoard(Integer.parseInt(seq));
		String id = (String) session.getAttribute("memId");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("memId" , id);
		mav.addObject("seq" , Integer.parseInt(seq));
		mav.addObject("pg" , Integer.parseInt(pg));
		mav.addObject("boardDTO", boardDTO);
		mav.addObject("display","/board/boardView.jsp");
		mav.setViewName("/main/index");
		return mav;
	}
	
//	@RequestMapping(value="/board/boardViewData" , method=RequestMethod.GET)
//	public ModelAndView boarViewData(@RequestParam String seq) {
//		
//		
//		ModelAndView mav = new ModelAndView();
//		
//		mav.addObject("display","/board/boardView.jsp");
//		mav.setViewName("/main/index");
//		return mav;
//	}
	
	@RequestMapping(value="/board/boardModifyForm" , method=RequestMethod.GET)
	public ModelAndView boardModifyForm(@RequestParam String pg,
										@RequestParam String seq) {
		BoardDTO boardDTO = boardService.getBoard(Integer.parseInt(seq));
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardDTO" , boardDTO);
		mav.addObject("pg" , Integer.parseInt(pg));
		mav.addObject("seq" , Integer.parseInt(seq));
		mav.addObject("display","/board/boardModifyForm.jsp");
		mav.setViewName("/main/index");
		return mav;
	}
	
	@RequestMapping(value="/board/boardModify" , method=RequestMethod.POST)
	public void boardModify(@RequestParam String seq,
							@RequestParam String modifySubject,
							@RequestParam String modifyContent) {
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("seq",seq);
		map.put("subject",modifySubject);
		map.put("content",modifyContent);
		
		boardService.boardModify(map);
	}
	
	
	@RequestMapping(value="/board/boardDelete" , method=RequestMethod.GET)
	public ModelAndView boardDelete(@RequestParam String seq) {
		boardService.boardDelete(Integer.parseInt(seq));
		return new ModelAndView("redirect:/board/boardList");
	}
	
	@RequestMapping(value="/board/boardSearch" , method=RequestMethod.POST)
	public ModelAndView boardSearch(@RequestParam Map<String, String> map) {
		
		int endNum = Integer.parseInt(map.get("pg"))*5;
		int startNum = endNum -4;
		
		map.put("startNum", startNum+"");
		map.put("endNum", endNum+"");
		
		List<BoardDTO> list =boardService.boardSearch(map);
		
		//검색된 리스트의 페이징처리
		int totalA = boardService.getSearchTotalA(map);
		boardPaging.setCurrentPage(Integer.parseInt(map.get("pg")));
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makeSearchPagingHTML();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("searchOption" , map.get("searchOption"));
		mav.addObject("keyword" , map.get("keyword"));
		mav.addObject("boardPaging" , boardPaging);
		mav.addObject("list",list);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="/board/boardReplyForm" , method=RequestMethod.GET)
	public ModelAndView boardReplyForm(@RequestParam Map<String, String> map) {
		System.out.println("pg = " + Integer.parseInt(map.get("pg")) + " , pseq = " + Integer.parseInt(map.get("pseq")));
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", Integer.parseInt(map.get("pg")));
		mav.addObject("pseq",Integer.parseInt(map.get("pseq")));
		mav.addObject("display","/board/boardReplyForm.jsp");
		mav.setViewName("/main/index");
		return mav;
	}
	
	@RequestMapping(value="/board/boardReply" , method=RequestMethod.POST)
	public void boardReply(@RequestParam Map<String, String> map,
										 HttpSession session) {
		
		String id = (String)session.getAttribute("memId");
		String name =(String)session.getAttribute("memName");
		String email = (String)session.getAttribute("memEmail");
		
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		
		boardService.boardReply(map);
		
		
		
	}
	
	
	
}
