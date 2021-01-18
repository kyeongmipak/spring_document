package com.springlec.base0502;

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
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	////////////////////////
	@RequestMapping("index")
	public String goIndex() {
		return "index";
		
	}
	
	// get/post 방식 둘다 사용 가능
	@RequestMapping("student")
	public String goStudent(HttpServletRequest httpServletRequest, Model model) {
		System.out.println("RequestMethod.GET");
		
		String name = httpServletRequest.getParameter("name");
		String age = httpServletRequest.getParameter("age");
		String grade = httpServletRequest.getParameter("grade");
		String ban = httpServletRequest.getParameter("ban");
		//System.out.println("id : " + id);
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("grade", grade);
		model.addAttribute("ban", ban);
		return "studentInfo";
	}
	
//	
//	@RequestMapping("student/{student}")
//	public String goStudent(@RequestParam String studentInfo, Model model) {
//	
//		model.addAttribute("student", studentInfo);
//		
//		return "student/studentInfo";
//	}
}
