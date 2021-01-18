package com.springlec.base0301;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	//-----------------------------------------------------
	// 추가
	@RequestMapping("board/view")  // url 내 경로 불러올때 사용
	public String view() { // view.jsp이면 method를 view로 만든다. 파일명과 동일하게
		
		// 실행하는 파일 부른다.
		return "board/view";
		
	}
	
	@RequestMapping("board/content") // model view 4
	public String content(Model model) {
		
		model.addAttribute("id",30); // Model을 사용하여 data 전달 (request 대신)	
		
		return "board/content";
		
	}
	
	@RequestMapping("board/reply") // model view 3
	public ModelAndView reply() { // model과 view 값을 같이 줘야한다.
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id", 30);
		modelAndView.setViewName("board/reply");
		return modelAndView;
		
		
	}
	
}
