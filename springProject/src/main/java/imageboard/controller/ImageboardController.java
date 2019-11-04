package imageboard.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.omg.CORBA.portable.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import imageboard.bean.ImageboardDTO;
import imageboard.bean.ImageboardPaging;
import imageboard.service.ImageboardService;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="imageboard")
public class ImageboardController {
	
	@Autowired
	private ImageboardService imageboardService;
	@Autowired
	private ImageboardPaging imageboardPaging;
	
	@RequestMapping(value="imageboardWriteForm" , method=RequestMethod.GET)
	public ModelAndView imageboardWriteForm(Model model) {
//		model.addAttribute("display" , "/imageboard/imageboardWriteForm.jsp");
//		return "/main/index";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("display", "/imageboard/imageboardWriteForm.jsp");
		mav.setViewName("/main/index");
		return mav;
	}

	//name="img" 가 1개일 경우
//	@RequestMapping(value="imageboardWrite" , method=RequestMethod.POST)
//	public void imageboardWrite(@ModelAttribute ImageboardDTO imageboardDTO,
//								@RequestParam MultipartFile img1,
//								Model model) {
//		
//		String filePath = "/Users/yangjaewoo/Spring/workSTS/springProject/src/main/webapp/storage";
//		String fileName = img1.getOriginalFilename();
//		File file = new File(filePath , fileName );
//		
//		try {
//			FileCopyUtils.copy(img1.getInputStream(), new FileOutputStream(file));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	
//		imageboardDTO.setImage1(fileName);
//		imageboardService.imageboardWrite(imageboardDTO);
//	}
	//name="img" 가 2개 이상일경우 - 배열로 받는다
//	@RequestMapping(value="imageboardWrite" , method=RequestMethod.POST)
//	public void imageboardWrite(@ModelAttribute ImageboardDTO imageboardDTO,
//								@RequestParam MultipartFile[] img,
//								Model model) {
//		
//		String filePath = "/Users/yangjaewoo/Spring/workSTS/springProject/src/main/webapp/storage";
//		String fileName = img[0].getOriginalFilename();
//		File file ;
//		
//		
//		if(img[0]!=null) {
//			fileName = img[0].getOriginalFilename();
//			file = new File(filePath, fileName);
//		
//			try {
//				FileCopyUtils.copy(img[0].getInputStream(), new FileOutputStream(file));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			imageboardDTO.setImage1(fileName);
//		}else {
//			imageboardDTO.setImage1(null);
//		}
//		//--------------
//		if(img[1]!=null) {
//			fileName = img[1].getOriginalFilename();
//			file = new File(filePath, fileName);
//		
//			try {
//				FileCopyUtils.copy(img[1].getInputStream(), new FileOutputStream(file));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			imageboardDTO.setImage2(fileName);
//		}else {
//			imageboardDTO.setImage2(null);
//		}
//		
//		imageboardService.imageboardWrite(imageboardDTO);
//	}
	//드래그해서 한번에 여러개의 파일을 선택했을때
	@RequestMapping(value="imageboardWrite" , method=RequestMethod.POST)
	public void imageboardWrite(@ModelAttribute ImageboardDTO imageboardDTO,
								@RequestParam("img[]") List<MultipartFile> list,
								Model model) {
		
		String filePath = "/Users/yangjaewoo/Spring/workSTS/springProject/src/main/webapp/storage";
		
		for(MultipartFile img : list) {
			String fileName = img.getOriginalFilename();
			File file = new File(filePath , fileName);
			
			try {
				FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			imageboardDTO.setImage1(fileName);
			imageboardService.imageboardWrite(imageboardDTO);
			
		}
		
	}
	
	
	@RequestMapping(value="imageboardList" , method=RequestMethod.GET)
	public String imageboardList(@RequestParam(required=false, defaultValue="1") String pg , Model model) {
		model.addAttribute("pg" , pg);
		model.addAttribute("display" , "/imageboard/imageboardList.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="getImageboardList" , method=RequestMethod.POST)
	public ModelAndView getImageboardList(@RequestParam(required=false, defaultValue="1") String pg) {
		int endNum = Integer.parseInt(pg) * 3; //한페이지당 5개
		int startNum = endNum - 2;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		List<ImageboardDTO> list = imageboardService.getImageboardList(map);
		
		//paging
		int totalA = imageboardService.getImageboardTotalA();
		imageboardPaging.setCurrentPage(Integer.parseInt(pg));
		imageboardPaging.setPageBlock(3);
		imageboardPaging.setPageSize(3);
		imageboardPaging.setTotalA(totalA);
		imageboardPaging.makePagingHTML();
		
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg" , pg);
		mav.addObject("list" , list);
		mav.addObject("imageboardPaging", imageboardPaging);
		mav.setViewName("jsonView");
		return mav;
	}
	
	
	@RequestMapping(value="imageboardDelete" , method=RequestMethod.GET)
	public String imageboardDelete(@RequestParam String[] check, Model model) {
		Map<String, String[]> map = new HashMap<String, String[]>(); //배열을 담아서 보내기 위해 사용한다.
		map.put("seq", check);
		
		imageboardService.imageboardDelete(map);
		model.addAttribute("display" ,"/imageboard/imageboardList.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="imageboardView", method=RequestMethod.GET)
	public String imageboardView(@RequestParam String seq, @RequestParam String pg, Model model) {
		model.addAttribute("seq", seq);
		model.addAttribute("pg", pg);
		model.addAttribute("display", "/imageboard/imageboardView.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="getImageboardView" , method=RequestMethod.POST)
	public ModelAndView getImageboardView(@RequestParam String seq) {
		ImageboardDTO imageboardDTO = imageboardService.getImageboardView(Integer.parseInt(seq));
		System.out.println(imageboardDTO);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("imageboardDTO", imageboardDTO);
		mav.setViewName("jsonView");
		return mav;
	}
	
}
