package imageboard.controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.omg.CORBA.portable.InputStream;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value="imageboard")
public class ImageboardController {

	
	@RequestMapping(value="imageboardWriteForm" , method=RequestMethod.GET)
	public ModelAndView imageboardWriteForm(Model model) {
//		model.addAttribute("display" , "/imageboard/imageboardWriteForm.jsp");
//		return "/main/index";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("display", "/imageboard/imageboardWriteForm.jsp");
		mav.setViewName("/main/index");
		return mav;
	}
	
	
	@RequestMapping(value="imageboardData" , method=RequestMethod.GET)
	public ModelAndView imageboardData(HttpServletRequest request,
								 HttpServletResponse response) throws Exception {
		
		String key = "58zvG2lO4rQJ9KKRBk8%2Bnft9DnY9P39%2F5NUlt9lqgCYg%2Fb3h9T%2BQYcWzEejk9vXcEn16HaubYuNEbgSQKgFDpQ%3D%3D";
		String addr = "http://openapi.jejusi.go.kr/rest/minbakinfoservice/getMinbakInfoList?ServiceKey="+key+"&pageNo=1&numOfRows=10";
		
		PrintWriter out = response.getWriter();
		
		URL url = new URL(addr);
		
		InputStream in = (InputStream) url.openStream();
		
		ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
		IOUtils.copy(in, bos1);
		in.close();
		bos1.close();
		
		String mbos = bos1.toString("UTF-8");
		
		byte[] b = mbos.getBytes("UTF-8");
		String s = new String(b,"UTF-8");
		out.println(s);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("data", s);
		mav.setViewName("jsonView");
		return mav;
	}
	
	
	
}
