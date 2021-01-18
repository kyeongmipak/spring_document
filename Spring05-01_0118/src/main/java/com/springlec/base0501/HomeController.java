package com.springlec.base0501;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	// 3번째 내용 추가	
	@RequestMapping("index")
	public String goIndex() {
		return "index";
		
	}
	
//	// get 방식의 method를 받을 때 여기 실행
//	@RequestMapping(method = RequestMethod.GET, value = "student")
//	public String goStudent(HttpServletRequest httpServletRequest, Model model) {
//		System.out.println("RequestMethod.GET");
//		
//		String id = httpServletRequest.getParameter("id");
//		System.out.println("id : " + id);
//		
//		model.addAttribute("studentId", id);
//		return "student/studentId";
//	}
//	
//	// POST 방식의 method를 받을 때 여기 실행
//	@RequestMapping(method = RequestMethod.POST, value = "student")
//	public ModelAndView goStudent(HttpServletRequest httpServletRequest) {
//		System.out.println("RequestMethod.POST");
//		
//		String id = httpServletRequest.getParameter("id");
//		System.out.println("id : " + id);
//		
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("student/studentId");
//		modelAndView.addObject("studentId", id);
//		
//		return modelAndView;
//	}
//	
	
		// get/post 방식 둘다 사용 가능
		@RequestMapping("student")
		public String goStudent(HttpServletRequest httpServletRequest, Model model) {
			System.out.println("RequestMethod.GET");
			
			String id = httpServletRequest.getParameter("id");
			System.out.println("id : " + id);
			
			model.addAttribute("studentId", id);
			return "student/studentId";
		}
		
	
}
